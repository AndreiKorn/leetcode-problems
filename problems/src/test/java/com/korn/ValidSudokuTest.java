package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidSudokuTest {
    @ParameterizedTest
    @MethodSource
    void isValidSudoku(char[][] board, boolean expectedResult) {
        boolean actualResult = new ValidSudoku().isValidSudoku(board);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> isValidSudoku() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        },
                        true
                ),
                Arguments.of(
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        true
                ),
                Arguments.of(
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '3', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                ),
                Arguments.of(
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '3', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                ),
                Arguments.of(
                        new char[][]{
                                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        false
                ),
                Arguments.of(
                        new char[][]{
                                {'3', '7', '9', '2', '4', '5', '8', '6', '1'},
                                {'2', '8', '5', '3', '6', '1', '9', '7', '4'},
                                {'1', '6', '4', '9', '7', '8', '2', '3', '5'},
                                {'9', '5', '8', '6', '3', '4', '1', '2', '7'},
                                {'4', '3', '7', '1', '9', '2', '6', '5', '8'},
                                {'6', '2', '1', '8', '5', '7', '4', '9', '3'},
                                {'7', '9', '2', '4', '1', '3', '5', '8', '6'},
                                {'8', '4', '3', '5', '2', '6', '7', '1', '9'},
                                {'5', '1', '6', '7', '8', '9', '3', '4', '2'}
                        },
                        true
                )
        );
    }
}
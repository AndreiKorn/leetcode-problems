package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SearchA2dMatrixTest {
    @ParameterizedTest
    @MethodSource
    void searchMatrix(int[][] matrix, int target, boolean expectedResult) {
        boolean actualResult = new SearchA2dMatrix().searchMatrix(matrix, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> searchMatrix() {
        return Stream.of(
                Arguments.of(new int[][]{{1}}, 8, false),
                Arguments.of(new int[][]{{1}, {8}}, 8, true),
                Arguments.of(new int[][]{{1, 2, 4}, {6, 8, 9}}, 8, true),
                Arguments.of(new int[][]{{1, 2, 4}, {6, 8, 9}}, 9, true),
                Arguments.of(new int[][]{{1, 2, 4}, {6, 8, 9}}, 6, true),
                Arguments.of(new int[][]{{1, 2, 4}, {6, 8, 9}}, 5, false),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3, true),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13, false),
                Arguments.of(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 11, true)
        );
    }
}
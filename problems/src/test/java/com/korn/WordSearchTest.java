package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordSearchTest {
    @ParameterizedTest
    @MethodSource
    void exist(char[][] board, String word, boolean expectedResult) {
        boolean actualResult = new WordSearch().exist(board, word);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> exist() {
        return Stream.of(
                Arguments.of(new char[][]{{'A'}}, "A", true),
                Arguments.of(new char[][]{{'A'}}, "B", false),
                Arguments.of(new char[][]{{'A', 'B'}}, "A", true),
                Arguments.of(new char[][]{{'A', 'B'}}, "AB", true),
                Arguments.of(new char[][]{{'A'}, {'B'}}, "AB", true),
                Arguments.of(new char[][]{{'A', 'B'}}, "BA", true),
                Arguments.of(new char[][]{{'A'}, {'B'}}, "BA", true),
                Arguments.of(new char[][]{{'A', 'B'}}, "ABA", false),
                Arguments.of(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'},
                        },
                        "ABCCED",
                        true
                ),
                Arguments.of(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'},
                        },
                        "SEE",
                        true
                ),
                Arguments.of(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'},
                        },
                        "SEA",
                        false
                ),
                Arguments.of(
                        new char[][]{
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'},
                        },
                        "ABCB",
                        false
                )
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SurroundedRegionsTest {
    @ParameterizedTest
    @MethodSource
    void solve(char[][] board, char[][] expectedResult) {
        new SurroundedRegions().solve(board);

        assertThat(board).isEqualTo(expectedResult);
    }

    static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of(new char[][]{{'X'}}, new char[][]{{'X'}}),
                Arguments.of(new char[][]{{'O'}}, new char[][]{{'O'}}),
                Arguments.of(new char[][]{{'X', 'O', 'X', 'X', 'O'}}, new char[][]{{'X', 'O', 'X', 'X', 'O'}}),
                Arguments.of(
                        new char[][]{{'X'}, {'O'}, {'X'}, {'X'}, {'O'}},
                        new char[][]{{'X'}, {'O'}, {'X'}, {'X'}, {'O'}}
                ),
                Arguments.of(
                        new char[][]{
                                {'O', 'O', 'O'},
                                {'O', 'O', 'O'},
                                {'O', 'O', 'O'}
                        },
                        new char[][]{
                                {'O', 'O', 'O'},
                                {'O', 'O', 'O'},
                                {'O', 'O', 'O'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X'},
                                {'X', 'O', 'X'},
                                {'X', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'O', 'X'},
                                {'X', 'O', 'X'},
                                {'X', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'O', 'X'},
                                {'X', 'O', 'X'},
                                {'X', 'X', 'X'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'},
                                {'X', 'X', 'X'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'X', 'X'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}
                        }
                )
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FloodFillTest {
    @ParameterizedTest
    @MethodSource
    void floodFill(int[][] image, int sr, int sc, int color, int[][] expectedResult) {
        int[][] actualResult = new FloodFill().floodFill(image, sr, sc, color);

        assertThat(actualResult).isDeepEqualTo(expectedResult);
    }

    static Stream<Arguments> floodFill() {
        return Stream.of(
                Arguments.of(new int[][]{{1}}, 0, 0, 2, new int[][]{{2}}),
                Arguments.of(new int[][]{{2}}, 0, 0, 2, new int[][]{{2}}),
                Arguments.of(new int[][]{{1, 0, 1}}, 0, 0, 2, new int[][]{{2, 0, 1}}),
                Arguments.of(new int[][]{{1, 1, 0}}, 0, 0, 2, new int[][]{{2, 2, 0}}),
                Arguments.of(new int[][]{{1}, {0}, {1}}, 0, 0, 2, new int[][]{{2}, {0}, {1}}),
                Arguments.of(new int[][]{{1}, {1}, {0}}, 0, 0, 2, new int[][]{{2}, {2}, {0}}),
                Arguments.of(
                        new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
                        1,
                        1,
                        2,
                        new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}
                ),
                Arguments.of(
                        new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
                        2,
                        2,
                        2,
                        new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 2}}
                ),
                Arguments.of(
                        new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                        2,
                        2,
                        5,
                        new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}}
                ),
                Arguments.of(
                        new int[][]{{5, 5, 0}, {1, 1, 0}, {2, 3, 1}},
                        0,
                        1,
                        5,
                        new int[][]{{5, 5, 0}, {1, 1, 0}, {2, 3, 1}}
                ),
                Arguments.of(
                        new int[][]{{0, 0, 0}, {0, 0, 0}},
                        1,
                        1,
                        2,
                        new int[][]{{2, 2, 2}, {2, 2, 2}}
                )
        );
    }
}
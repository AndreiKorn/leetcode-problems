package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumVacationDaysTest {
    @ParameterizedTest
    @MethodSource
    void maxVacationDays(int[][] flights, int[][] days, int expectedResult) {
        int actualResult = new MaximumVacationDays().maxVacationDays(flights, days);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxVacationDays() {
        return Stream.of(
                Arguments.of(new int[][]{{0}}, new int[][]{{7, 5, 1}}, 13),
                Arguments.of(new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, new int[][]{{1}, {6}, {3}}, 6),
                Arguments.of(
                        new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}},
                        new int[][]{{1, 3, 1}, {6, 0, 3}, {3, 3, 3}},
                        12
                ),
                Arguments.of(
                        new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new int[][]{{1, 1, 1}, {7, 7, 7}, {7, 7, 7}},
                        3
                ),
                Arguments.of(
                        new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}},
                        new int[][]{{7, 0, 0}, {0, 7, 0}, {0, 0, 7}},
                        21
                ),
                Arguments.of(
                        new int[][]{{0, 1, 1, 0}, {1, 0, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}},
                        new int[][]{{1, 3}, {5, 4}, {7, 6}, {1, 21}},
                        28
                )
        );
    }
}
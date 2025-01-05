package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumProfitInJobSchedulingTest {
    @ParameterizedTest
    @MethodSource
    void jobScheduling(int[] startTime, int[] endTime, int[] profit, int expectedResult) {
        int actualResult = new MaximumProfitInJobScheduling().jobScheduling(startTime, endTime, profit);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> jobScheduling() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{2}, new int[]{5}, 5),
                Arguments.of(new int[]{1, 1, 1}, new int[]{2, 3, 5}, new int[]{8, 1, 4}, 8),
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}, 120),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}, 150),
                Arguments.of(new int[]{1, 6, 8, 12}, new int[]{3, 8, 10, 15}, new int[]{15, 5, 10, 20}, 50),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, new int[]{4, 5, 10, 6, 9}, new int[]{20, 20, 200, 70, 60}, 200)
        );
    }
}
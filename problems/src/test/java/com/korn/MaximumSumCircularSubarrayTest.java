package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSumCircularSubarrayTest {
    @ParameterizedTest
    @MethodSource
    void maxSubarraySumCircular(int[] nums, int expectedResult) {
        int actualResult = new MaximumSumCircularSubarray().maxSubarraySumCircular(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxSubarraySumCircular() {
        return Stream.of(
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{-1}, -1),
                Arguments.of(new int[]{1, -2, 3, -2}, 3),
                Arguments.of(new int[]{5, -3, 5}, 10),
                Arguments.of(new int[]{-3, -2, -3}, -2),
                Arguments.of(new int[]{2, 3, 5}, 10),
                Arguments.of(new int[]{2, -1}, 2),
                Arguments.of(new int[]{3, -1, 2, -1}, 4)
        );
    }
}
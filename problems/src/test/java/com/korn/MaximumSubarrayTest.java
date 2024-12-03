package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumSubarrayTest {
    @ParameterizedTest
    @MethodSource
    void maxSubArray(int[] input, int expectedResult) {
        int actualResult = new MaximumSubarray().maxSubArray(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxSubArray() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-1}, -1),
                Arguments.of(new int[]{-2, 1}, 1),
                Arguments.of(new int[]{-1, -2, -3}, -1),
                Arguments.of(new int[]{10000, 10000, -10000, -10000}, 20000)
        );
    }
}
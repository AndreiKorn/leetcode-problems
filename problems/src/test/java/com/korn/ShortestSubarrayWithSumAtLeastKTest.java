package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestSubarrayWithSumAtLeastKTest {
    @ParameterizedTest
    @MethodSource
    void shortestSubarray(int[] nums, int k, int expectedResult) {
        int actualResult = new ShortestSubarrayWithSumAtLeastK().shortestSubarray(nums, k);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> shortestSubarray() {
        return Stream.of(
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(new int[]{1}, 5, -1),
                Arguments.of(new int[]{5}, 5, 1),
                Arguments.of(new int[]{1, 2}, 4, -1),
                Arguments.of(new int[]{1, 2}, 2, 1),
                Arguments.of(new int[]{1, 2}, 3, 2),
                Arguments.of(new int[]{2, -1, 2}, 3, 2),
                Arguments.of(new int[]{2, -1, 2}, 4, -1),
                Arguments.of(new int[]{2, -1, 2}, 1, 1),
                Arguments.of(new int[]{-5, 1, -4, 8}, -3, 1),
                Arguments.of(new int[]{56, -21, 56, 35, -9}, 61, 2)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MakeSumDivisibleByPTest {
    @ParameterizedTest
    @MethodSource
    void minSubarray(int[] nums, int p, int expectedResult) {
        int actualResult = new MakeSumDivisibleByP().minSubarray(nums, p);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> minSubarray() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 4, 2}, 6, 1),
                Arguments.of(new int[]{3, 4, 1, 2}, 6, 1),
                Arguments.of(new int[]{4, 3, 1, 2}, 6, 1),
                Arguments.of(new int[]{6, 3, 5, 2}, 9, 2),
                Arguments.of(new int[]{1, 2, 3}, 3, 0),
                Arguments.of(new int[]{5, 5, 3}, 6, -1),
                Arguments.of(new int[]{1, 2, 3}, 7, -1),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{1, 1, 1}, 2, 1),
                Arguments.of(new int[]{26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3}, 26, 3)
        );
    }
}
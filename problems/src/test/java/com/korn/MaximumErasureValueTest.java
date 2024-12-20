package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumErasureValueTest {
    @ParameterizedTest
    @MethodSource
    void maximumUniqueSubarray(int[] nums, int expectedResult) {
        int actualResult = new MaximumErasureValue().maximumUniqueSubarray(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maximumUniqueSubarray() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{51, 51}, 51),
                Arguments.of(new int[]{1, 51, 1}, 52),
                Arguments.of(new int[]{4, 1, 4, 2}, 7),
                Arguments.of(new int[]{2, 3}, 5),
                Arguments.of(new int[]{3, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{2, 1, 3}, 6),
                Arguments.of(new int[]{3, 2, 1}, 6),
                Arguments.of(new int[]{3, 2, 1, 2, 2, 1, 2, 3, 3, 3, 2, 1, 3, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 4, 5, 6}, 17),
                Arguments.of(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}, 8)
        );
    }
}
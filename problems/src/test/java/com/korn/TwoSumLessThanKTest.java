package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumLessThanKTest {
    @ParameterizedTest
    @MethodSource
    void twoSumLessThanK(int[] nums, int k, int expectedResult) {
        int actualResult = new TwoSumLessThanK().twoSumLessThanK(nums, k);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> twoSumLessThanK() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, -1),
                Arguments.of(new int[]{5}, 10, -1),
                Arguments.of(new int[]{1, 2, 5}, 10, 7),
                Arguments.of(new int[]{5, 1, 2}, 10, 7),
                Arguments.of(new int[]{1, 5}, 3, -1),
                Arguments.of(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60, 58),
                Arguments.of(new int[]{34, 37, 1, 24, 21, 33, 54, 8}, 60, 58),
                Arguments.of(new int[]{10, 15, 30}, 10, -1),
                Arguments.of(new int[]{10, 15, 30}, 20, -1),
                Arguments.of(new int[]{10, 15, 30}, 30, 25)
        );
    }
}
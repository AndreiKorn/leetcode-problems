package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumIiInputArrayIsSortedTest {
    @ParameterizedTest
    @MethodSource
    void twoSum(int[] numbers, int target, int[] expectedResult) {
        int[] actualResult = new TwoSumIiInputArrayIsSorted().twoSum(numbers, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> twoSum() {
        return Stream.of(
                Arguments.of(new int[]{1}, 2, new int[]{-1, -1}),
                Arguments.of(new int[]{1, 2}, 1, new int[]{-1, -1}),
                Arguments.of(new int[]{1, 2}, 3, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 2, new int[]{-1, -1}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 13, new int[]{1, 6}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 11, new int[]{1, 5}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 14, new int[]{2, 6}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 12, new int[]{2, 5}),
                Arguments.of(new int[]{2, 3, 6, 7, 9, 11}, 16, new int[]{4, 5}),
                Arguments.of(new int[]{-5, -2, -1, 0, 1, 2, 5}, -7, new int[]{1, 2}),
                Arguments.of(new int[]{-5, -2, -1, 0, 1, 2, 5}, -1, new int[]{2, 5}),
                Arguments.of(new int[]{-5, -2, -1, 0, 1, 2, 5}, 0, new int[]{1, 7}),
                Arguments.of(new int[]{-5, -2, -1, 0, 1, 2, 5}, 2, new int[]{4, 6})
        );
    }
}
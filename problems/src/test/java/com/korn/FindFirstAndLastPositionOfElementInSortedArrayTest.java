package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindFirstAndLastPositionOfElementInSortedArrayTest {
    @ParameterizedTest
    @MethodSource
    void searchRange(int[] nums, int target, int[] expectedResult) {
        int[] actualResult = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> searchRange() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1}),
                Arguments.of(new int[]{1}, 1, new int[]{0, 0}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, new int[]{4, 4}),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, new int[]{0, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, new int[]{0, 0}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, new int[]{9, 9}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, new int[]{-1, -1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11, new int[]{-1, -1})
        );
    }
}
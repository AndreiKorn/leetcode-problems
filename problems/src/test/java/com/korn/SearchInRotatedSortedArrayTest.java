package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SearchInRotatedSortedArrayTest {
    @ParameterizedTest
    @MethodSource
    void search(int[] nums, int target, int expectedResult) {
        int actualResult = new SearchInRotatedSortedArray().search(nums, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> search() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{2, 1}, 1, 1),
                Arguments.of(new int[]{3, 4, 5, -10, 1, 2}, 1, 4),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, 3, 3),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, 1, 1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 6, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 4),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{3, 1}, 2, -1),
                Arguments.of(new int[]{3, 4, 5, -10, 1, 2}, 0, -1),
                Arguments.of(new int[]{3, 4, 5, -10, 1, 2}, 18, -1),
                Arguments.of(new int[]{4, 5, 7, 0, 1, 2}, 6, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 8, -1)
        );
    }
}
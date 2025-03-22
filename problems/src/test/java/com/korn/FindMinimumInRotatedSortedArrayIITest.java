package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindMinimumInRotatedSortedArrayIITest {
    @ParameterizedTest
    @MethodSource
    void findMin(int[] nums, int expectedResult) {
        int actualResult = new FindMinimumInRotatedSortedArrayII().findMin(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> findMin() {
        return Stream.of(
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{2, 0}, 0),
                Arguments.of(new int[]{0, 2, 0}, 0),
                Arguments.of(new int[]{0, 2, 1}, 0),
                Arguments.of(new int[]{1, 3, 5}, 1),
                Arguments.of(new int[]{2, 2, 2, 0, 1}, 0),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 1),
                Arguments.of(new int[]{4, 5, 6, 1, 2, 3}, 1),
                Arguments.of(new int[]{2, 3, 4, 5, 6, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 4, 4, 4, 4, 4}, 1),
                Arguments.of(new int[]{4, 4, 4, 4, 4, 1, 2, 4}, 1)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargestElementInAnArrayTest {
    @ParameterizedTest
    @MethodSource
    void findKthLargest(int[] nums, int k, int expectedResult) {
        int actualResult = new KthLargestElementInAnArray().findKthLargest(nums, k);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> findKthLargest() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{1, 2}, 1, 2),
                Arguments.of(new int[]{2, 2, 3, 3}, 2, 3),
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
                Arguments.of(new int[]{-10000, -10000, 0, 10000}, 2, 0)
        );
    }
}
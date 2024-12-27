package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class KthMissingPositiveNumberTest {
    @ParameterizedTest
    @MethodSource
    void findKthPositive(int[] arr, int k, int expectedResult) {
        int actualResult = new KthMissingPositiveNumber().findKthPositive(arr, k);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> findKthPositive() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 2),
                Arguments.of(new int[]{1, 2, 3}, 1, 4),
                Arguments.of(new int[]{1, 2, 3}, 1, 4),
                Arguments.of(new int[]{1, 2, 3}, 5, 8),
                Arguments.of(new int[]{3, 4, 5}, 2, 2),
                Arguments.of(new int[]{2, 3, 4}, 5, 8),
                Arguments.of(new int[]{1, 10, 20}, 5, 6),
                Arguments.of(new int[]{2, 4, 7}, 3, 5),
                Arguments.of(new int[]{2, 4, 7}, 3, 5),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 2, 4),
                Arguments.of(new int[]{1, 3, 8}, 100, 103),
                Arguments.of(new int[]{1, 1000, 10000}, 100, 101)
        );
    }
}
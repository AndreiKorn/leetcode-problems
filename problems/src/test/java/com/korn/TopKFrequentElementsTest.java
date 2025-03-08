package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class TopKFrequentElementsTest {
    @ParameterizedTest
    @MethodSource
    void topKFrequent(int[] nums, int k, int[] expectedResult) {
        int[] actualResult = new TopKFrequentElements().topKFrequent(nums, k);

        assertThat(actualResult).containsExactlyInAnyOrder(expectedResult);
    }

    static Stream<Arguments> topKFrequent() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 1, 1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3, 1, 3, 4, 5, 4, 3, 3, 3}, 2, new int[]{1, 3})
        );
    }
}
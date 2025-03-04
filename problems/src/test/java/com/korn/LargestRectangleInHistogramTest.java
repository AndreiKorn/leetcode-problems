package com.korn;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LargestRectangleInHistogramTest {
    @ParameterizedTest
    @MethodSource
    void largestRectangleArea(int[] heights, int expectedResult) {
        int actualResult = new LargestRectangleInHistogram().largestRectangleArea(heights);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> largestRectangleArea() {
        return Stream.of(
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{1, 5}, 5),
                Arguments.of(new int[]{3, 5}, 6),
                Arguments.of(new int[]{2, 4}, 4),
                Arguments.of(new int[]{2, 1, 5, 6, 2, 3}, 10),
                Arguments.of(new int[]{2, 100, 5, 6, 2, 3}, 100),
                Arguments.of(new int[]{15, 6, 5, 6, 2, 3}, 20),
                Arguments.of(new int[]{1, 6, 5, 6, 3, 9, 3, 3}, 21)
        );
    }
}
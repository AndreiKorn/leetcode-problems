package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class SlidingWindowMedianTest {
    @ParameterizedTest
    @MethodSource
    void medianSlidingWindow(int[] nums, int k, double[] expectedResult) {
        double[] actualResult = new SlidingWindowMedian().medianSlidingWindow(nums, k);

        assertThat(actualResult).containsExactly(expectedResult, withPrecision(0.0001));
    }

    static Stream<Arguments> medianSlidingWindow() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, new double[]{1}),
                Arguments.of(new int[]{-2147483648}, 1, new double[]{-2147483648}),
                Arguments.of(new int[]{2147483647}, 1, new double[]{2147483647}),
                Arguments.of(new int[]{1, 2}, 1, new double[]{1, 2}),
                Arguments.of(new int[]{1, 2}, 2, new double[]{1.5}),
                Arguments.of(new int[]{1, 2, 3, 4}, 1, new double[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, 2, new double[]{1.5, 2.5, 3.5}),
                Arguments.of(new int[]{1, 2, 3, 4}, 3, new double[]{2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4}, 4, new double[]{2.5}),
                Arguments.of(new int[]{4, 4, 4, 4}, 2, new double[]{4, 4, 4}),
                Arguments.of(new int[]{4, 4, 4, 4}, 3, new double[]{4, 4}),
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new double[]{1, -1, -1, 3, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3, new double[]{2, 3, 3, 3, 2, 3, 2}),
                Arguments.of(new int[]{1, 4, 2, 3}, 4, new double[]{2.5}),
                Arguments.of(new int[]{3, -3, 1, 15, -8, 1, 0, -18}, 6, new double[]{1.0, 0.5, 0.5}),
                Arguments.of(new int[]{2147483647, 2147483647}, 2, new double[]{2147483647}),
                Arguments.of(
                        new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647},
                        2,
                        new double[]{1073741824, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1073741827}
                ),
                Arguments.of(
                        new int[]{
                                -2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22,
                                -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647,
                                -2147483648, 2147483647, -2147483648
                        },
                        6,
                        new double[]{
                                -1073741823.5, -1073741823.5, -49.5, -49.5, 2, 5.5, -46, -46, 12.5, 19.5,
                                1073741834.5, 2147483647, 2147483647, 2147483647, 2147483647
                        }
                )
        );
    }
}
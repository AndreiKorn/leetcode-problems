package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {
    @ParameterizedTest
    @MethodSource
    void maxArea(int[] height, int expectedResult) {
        int actualResult = new ContainerWithMostWater().maxArea(height);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxArea() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{2, 2}, 2),
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{7, 8, 6, 2, 5, 4, 8, 3, 7}, 56),
                Arguments.of(new int[]{7, 8, 6, 2, 5, 4, 3, 8, 7}, 56),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 6),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 6),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, 15),
                Arguments.of(new int[]{1, 2, 3, 4, 25, 25, 4, 3, 2, 1}, 25),
                Arguments.of(new int[]{7, 8, 42, 2, 30, 4, 3, 8, 7}, 60),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 20)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArrayTest {
    @ParameterizedTest
    @MethodSource("rotate")
    void rotateReversing(int[] nums, int k, int[] expectedResult) {
        new RotateArray().rotateReversing(nums, k);

        assertThat(nums).isEqualTo(expectedResult);
    }
    
    @ParameterizedTest
    @MethodSource("rotate")
    void rotateWithCycle(int[] nums, int k, int[] expectedResult) {
        new RotateArray().rotateWithCycle(nums, k);

        assertThat(nums).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("rotate")
    void rotateWithAdditionalMemory(int[] nums, int k, int[] expectedResult) {
        new RotateArray().rotateWithAdditionalMemory(nums, k);

        assertThat(nums).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> rotate() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0, new int[]{1}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1}, 5, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{6, 7, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 7, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 12, new int[]{3, 4, 5, 6, 7, 1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 0, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{5, 6, 1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{4, 5, 6, 1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 11, new int[]{2, 3, 4, 5, 6, 1}),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2}, 0, new int[]{2, 2, 2, 2, 2, 2, 2}),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2}, 3, new int[]{2, 2, 2, 2, 2, 2, 2}),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2}, 7, new int[]{2, 2, 2, 2, 2, 2, 2}),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2}, 12, new int[]{2, 2, 2, 2, 2, 2, 2}),
                Arguments.of(new int[]{5, -5, 5, -5, 5, -5}, 0, new int[]{5, -5, 5, -5, 5, -5}),
                Arguments.of(new int[]{5, -5, 5, -5, 5, -5}, 1, new int[]{-5, 5, -5, 5, -5, 5}),
                Arguments.of(new int[]{5, -5, 5, -5, 5, -5}, 2, new int[]{5, -5, 5, -5, 5, -5}),
                Arguments.of(new int[]{5, -5, 5, -5, 5, -5}, 3, new int[]{-5, 5, -5, 5, -5, 5}),
                Arguments.of(new int[]{5, -5, 5, -5, 5, -5}, 10, new int[]{5, -5, 5, -5, 5, -5})
        );
    }
}
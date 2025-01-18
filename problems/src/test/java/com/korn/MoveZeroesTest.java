package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveZeroesTest {
    @ParameterizedTest
    @MethodSource
    void moveZeroes(int[] nums, int[] expectedResult) {
        new MoveZeroes().moveZeroes(nums);

        assertThat(nums).isEqualTo(expectedResult);
    }

    static Stream<Arguments> moveZeroes() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 0, 3}, new int[]{1, 3, 0}),
                Arguments.of(new int[]{1, 0, 3}, new int[]{1, 3, 0}),
                Arguments.of(new int[]{1, 0, 3, 15, 0}, new int[]{1, 3, 15, 0, 0}),
                Arguments.of(new int[]{1, 0, 3, 15, 0, 12}, new int[]{1, 3, 15, 12, 0, 0}),
                Arguments.of(new int[]{1, 2, 3, 15, 6, 12}, new int[]{1, 2, 3, 15, 6, 12}),
                Arguments.of(new int[]{1, 0, 3, 15, 6, 12}, new int[]{1, 3, 15, 6, 12, 0}),
                Arguments.of(new int[]{0, 2, 3, 15, 6, 12}, new int[]{2, 3, 15, 6, 12, 0}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0, 0}),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0})
        );
    }
}
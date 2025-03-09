package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ContiguousArrayTest {
    @ParameterizedTest
    @MethodSource
    void findMaxLength(int[] nums, int expectedResult) {
        int actualResult = new ContiguousArray().findMaxLength(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> findMaxLength() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{1, 0, 0}, 2),
                Arguments.of(new int[]{1, 0, 0, 1}, 4),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1}, 6),
                Arguments.of(new int[]{1, 0, 1, 0, 1, 0}, 6),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}, 6),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 1, 0, 0, 0}, 10),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 0}, 10),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1}, 10),
                Arguments.of(new int[]{1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, 4)
        );
    }
}
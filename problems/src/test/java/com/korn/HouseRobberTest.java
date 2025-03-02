package com.korn;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberTest {
    @ParameterizedTest
    @MethodSource
    void rob(int[] nums, int expectedResult) {
        int actualResult = new HouseRobber().rob(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> rob() {
        return Stream.of(
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 1}, 2),
                Arguments.of(new int[]{1, 1, 1}, 2),
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 1, 1, 2}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }
}
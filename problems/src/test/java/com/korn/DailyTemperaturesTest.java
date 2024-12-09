package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DailyTemperaturesTest {
    @ParameterizedTest
    @MethodSource("dailyTemperatures")
    void dailyTemperaturesMovingBackwards(int[] temperatures, int[] expectedResult) {
        int[] actualResult = new DailyTemperatures().dailyTemperaturesMovingBackwards(temperatures);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("dailyTemperatures")
    void dailyTemperaturesWithStack(int[] temperatures, int[] expectedResult) {
        int[] actualResult = new DailyTemperatures().dailyTemperaturesWithStack(temperatures);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> dailyTemperatures() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{30}, new int[]{0}),
                Arguments.of(new int[]{30, 30}, new int[]{0, 0}),
                Arguments.of(new int[]{40, 30}, new int[]{0, 0}),
                Arguments.of(new int[]{30, 40}, new int[]{1, 0}),
                Arguments.of(new int[]{30, 30, 40}, new int[]{2, 1, 0}),
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0})
        );
    }
}
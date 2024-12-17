package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangeTest {
    @ParameterizedTest
    @MethodSource
    void coinChange(int[] coins, int amount, int expectedResult) {
        int actualResult = new CoinChange().coinChange(coins, amount);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> coinChange() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5}, 0, 0),
                Arguments.of(new int[]{1, 2, 5}, 3, 2),
                Arguments.of(new int[]{2}, 2, 1),
                Arguments.of(new int[]{1}, 2, 2),
                Arguments.of(new int[]{2}, 1, -1),
                Arguments.of(new int[]{1, 2, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000}, 983, 8),
                Arguments.of(new int[]{1, Integer.MAX_VALUE}, 3, 3),
                Arguments.of(new int[]{1, Integer.MAX_VALUE}, 10000, 10000),
                Arguments.of(new int[]{1, 5000}, 10000, 2),
                Arguments.of(new int[]{2, 10000}, 10000, 1),
                Arguments.of(new int[]{1, 2, 5}, 8, 3),
                Arguments.of(new int[]{1, 9, 12}, 8, 8),
                Arguments.of(new int[]{2, 4, 6}, 9, -1)
        );
    }
}
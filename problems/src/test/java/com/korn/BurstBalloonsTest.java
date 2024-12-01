package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class BurstBalloonsTest {
    @ParameterizedTest
    @MethodSource
    void maxCoins(int[] inputNums, int expectedResult) {
        int actualResult = new BurstBalloons().maxCoins(inputNums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxCoins() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 5, 8}, 167),
                Arguments.of(new int[]{1, 5}, 10),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 110),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 7462),
                Arguments.of(new int[]{13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 7462),
                Arguments.of(new int[]{0, 1, 2}, 4),
                Arguments.of(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3}, 1654),
                Arguments.of(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5}, 3630)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class GuessNumberHigherOrLowerTest {
    @ParameterizedTest
    @MethodSource
    void guessNumber(int pick, int n) {
        int actualResult = new GuessNumberHigherOrLower(pick).guessNumber(n);

        assertThat(actualResult).isEqualTo(pick);
    }

    static Stream<Arguments> guessNumber() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 2),
                Arguments.of(1, 10),
                Arguments.of(5, 10),
                Arguments.of(6, 10),
                Arguments.of(10, 10),
                Arguments.of(1, 100),
                Arguments.of(25, 100),
                Arguments.of(50, 100),
                Arguments.of(75, 100),
                Arguments.of(100, 100)
        );
    }
}
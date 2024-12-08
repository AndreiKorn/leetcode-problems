package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateReversePolishNotationTest {
    @ParameterizedTest
    @MethodSource
    void evalRPN(String[] tokens, int expectedResult) {
        int actualResult = new EvaluateReversePolishNotation().evalRPN(tokens);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> evalRPN() {
        return Stream.of(
                Arguments.of(new String[]{"1"}, 1),
                Arguments.of(new String[]{"1", "1", "+",}, 2),
                Arguments.of(new String[]{"2", "2", "-",}, 0),
                Arguments.of(new String[]{"2", "2", "*",}, 4),
                Arguments.of(new String[]{"2", "2", "/",}, 1),
                Arguments.of(new String[]{"5", "2", "/",}, 2),
                Arguments.of(new String[]{"4", "8", "+", "1", "3", "+", "/"}, 3),
                Arguments.of(new String[]{"28", "6", "2", "4", "*", "+", "/"}, 2),
                Arguments.of(new String[]{"4", "2", "5", "*", "+", "1", "3", "2", "*", "+", "/"}, 2),
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }
}
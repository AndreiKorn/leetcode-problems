package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveAllAdjacentDuplicatesInStringTest {
    @ParameterizedTest
    @MethodSource("removeDuplicates")
    void removeDuplicatesWithStack(String input, String expectedResult) {
        String actualResult = new RemoveAllAdjacentDuplicatesInString().removeDuplicatesWithStack(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicates")
    void removeDuplicatesWithStringBuilder(String input, String expectedResult) {
        String actualResult = new RemoveAllAdjacentDuplicatesInString().removeDuplicatesWithStringBuilder(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("removeDuplicates")
    void removeDuplicatesWithTwoPointers(String input, String expectedResult) {
        String actualResult = new RemoveAllAdjacentDuplicatesInString().removeDuplicatesWithTwoPointers(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> removeDuplicates() {
        return Stream.of(
                Arguments.of("a", "a"),
                Arguments.of("aa", ""),
                Arguments.of("ab", "ab"),
                Arguments.of("ba", "ba"),
                Arguments.of("aaa", "a"),
                Arguments.of("aab", "b"),
                Arguments.of("abbaca", "ca"),
                Arguments.of("azxxzy", "ay")
        );
    }
}
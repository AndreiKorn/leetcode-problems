package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringTest {
    @ParameterizedTest
    @MethodSource
    void longestPalindrome(String s, String expectedResult) {
        String actualResult = new LongestPalindromicSubstring().longestPalindrome(s);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> longestPalindrome() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("a", "a"),
                Arguments.of("b", "b"),
                Arguments.of("abba", "abba"),
                Arguments.of("racecar", "racecar"),
                Arguments.of("someword", "s"),
                Arguments.of("xapar", "apa"),
                Arguments.of("apar", "apa"),
                Arguments.of("xapa", "apa"),
                Arguments.of("xappar", "appa"),
                Arguments.of("ttaa", "tt"),
                Arguments.of("ttaaa", "aaa"),
                Arguments.of("1234321", "1234321")
        );
    }
}
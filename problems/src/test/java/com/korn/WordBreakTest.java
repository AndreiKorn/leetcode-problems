package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordBreakTest {
    @ParameterizedTest
    @MethodSource
    void wordBreak(String s, List<String> wordDict, boolean expectedResult) {
        boolean actualResult = new WordBreak().wordBreak(s, wordDict);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> wordBreak() {
        return Stream.of(
                Arguments.of("a", List.of("a"), true),
                Arguments.of("a", List.of("b"), false),
                Arguments.of("a", List.of("b", "c"), false),
                Arguments.of("a", List.of("a", "c"), true),
                Arguments.of("aa", List.of("a"), true),
                Arguments.of("abc", List.of("a", "b", "c"), true),
                Arguments.of("abc", List.of("abc"), true),
                Arguments.of("abc", List.of("ab", "c"), true),
                Arguments.of("abc", List.of("a", "bc"), true),
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("leetcode", List.of("leetcode", "leet", "code"), true),
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                Arguments.of("dogsanddogs", List.of("dogs", "anddo", "gs"), true),
                Arguments.of("dogsanddogs", List.of("dogs", "ando", "gs"), false),
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }
}
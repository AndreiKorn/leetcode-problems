package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RansomNoteTest {
    @ParameterizedTest
    @MethodSource
    void canConstruct(String ransomNote, String magazine, boolean expectedResult) {
        boolean actualResult = new RansomNote().canConstruct(ransomNote, magazine);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> canConstruct() {
        return Stream.of(
                Arguments.of("", "", true),
                Arguments.of("", "abcd", true),
                Arguments.of("abcd", "abcd", true),
                Arguments.of("abcd", "bacd", true),
                Arguments.of("abcd", "bcda", true),
                Arguments.of("abcd", "aabbccdd", true),
                Arguments.of("aaa", "aa", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aba", true),
                Arguments.of("abcd", "", false)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class GreatestCommonDivisorOfStringsTest {
    @ParameterizedTest
    @MethodSource
    void gcdOfStrings(String str1, String str2, String expectedResult) {
        String actualResult = new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> gcdOfStrings() {
        return Stream.of(
                Arguments.of("AAAAAAA", "AAA", "A"),
                Arguments.of("AAAAAAAA", "AAAA", "AAAA"),
                Arguments.of("ABAAAAAA", "ABA", ""),
                Arguments.of("ABCABC", "ABC", "ABC"),
                Arguments.of("ABC", "ABCABC", "ABC"),
                Arguments.of("ABCABC", "ABCABC", "ABCABC"),
                Arguments.of("ABCABCABC", "ABCABC", "ABC"),
                Arguments.of("ABCABC", "ABCABCABC", "ABC"),
                Arguments.of("ABCABCABCABC", "ABCABC", "ABCABC"),
                Arguments.of("ABCABCDBCABC", "ABCABC", ""),
                Arguments.of("LEET", "CODE", "")
        );
    }
}
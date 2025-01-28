package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class OddStringDifferenceTest {
    @ParameterizedTest
    @MethodSource
    void oddString(String[] words, String expectedResult) {
        String actualResult = new OddStringDifference().oddString(words);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> oddString() {
        return Stream.of(
                Arguments.of(new String[]{"ae", "dh", "bc"}, "bc"),
                Arguments.of(new String[]{"adc", "wzy", "abc"}, "abc"),
                Arguments.of(new String[]{"adc", "abc", "wzy"}, "abc"),
                Arguments.of(new String[]{"abc", "adc", "wzy"}, "abc"),
                Arguments.of(new String[]{"aaa", "bob", "ccc", "ddd"}, "bob"),
                Arguments.of(new String[]{"bob", "aaa", "ccc", "ddd"}, "bob"),
                Arguments.of(new String[]{"aaa", "ccc", "bob", "ddd"}, "bob"),
                Arguments.of(new String[]{"aaa", "ccc", "ddd", "bob"}, "bob"),
                Arguments.of(new String[]{"abm", "bcn", "alm"}, "alm")
        );
    }
}
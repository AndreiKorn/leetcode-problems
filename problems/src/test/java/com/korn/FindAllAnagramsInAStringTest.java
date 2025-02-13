package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllAnagramsInAStringTest {
    @ParameterizedTest
    @MethodSource
    void findAnagrams(String s, String p, List<Integer> expectedResult) {
        List<Integer> actualResult = new FindAllAnagramsInAString().findAnagrams(s, p);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> findAnagrams() {
        return Stream.of(
                Arguments.of("a", "a", List.of(0)),
                Arguments.of("a", "b", List.of()),
                Arguments.of("aaaaaaaaa", "a", List.of(0, 1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.of("aaaaaaaaa", "aa", List.of(0, 1, 2, 3, 4, 5, 6, 7)),
                Arguments.of("aaa", "aaaa", List.of()),
                Arguments.of("ababbabba", "ba", List.of(0, 1, 2, 4, 5, 7)),
                Arguments.of("ababbabba", "ab", List.of(0, 1, 2, 4, 5, 7)),
                Arguments.of("ababbabba", "ac", List.of()),
                Arguments.of("shazzbazz", "bazzshazz", List.of(0)),
                Arguments.of("cbaebabacd", "abc", List.of(0, 6))
        );
    }
}
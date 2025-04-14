package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromePartitioningTest {
    @ParameterizedTest
    @MethodSource
    void partition(String s, List<List<String>> expectedResult) {
        List<List<String>> actualResult = new PalindromePartitioning().partition(s);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> partition() {
        return Stream.of(
                Arguments.of("", List.of(List.of())),
                Arguments.of("a", List.of(List.of("a"))),
                Arguments.of("ab", List.of(List.of("a", "b"))),
                Arguments.of("aba", List.of(List.of("a", "b", "a"), List.of("aba"))),
                Arguments.of("aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
                Arguments.of(
                        "aabb",
                        List.of(
                                List.of("a", "a", "b", "b"),
                                List.of("aa", "b", "b"),
                                List.of("a", "a", "bb"),
                                List.of("aa", "bb")
                        )
                ),
                Arguments.of(
                        "aabbc",
                        List.of(
                                List.of("a", "a", "b", "b", "c"),
                                List.of("a", "a", "bb", "c"),
                                List.of("aa", "b", "b", "c"),
                                List.of("aa", "bb", "c")
                        )
                )
        );
    }
}
package com.korn;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagramsTest {
    @ParameterizedTest
    @MethodSource
    void groupAnagrams(String[] strs, List<List<String>> expectedResult) {
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);

        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> groupAnagrams() {
        return Stream.of(
                Arguments.of(new String[]{""}, List.of(List.of(""))),
                Arguments.of(new String[]{"a"}, List.of(List.of("a"))),
                Arguments.of(new String[]{"a", "b"}, List.of(List.of("a"), List.of("b"))),
                Arguments.of(
                        new String[]{"ddddddddddg", "dgggggggggg"},
                        List.of(List.of("ddddddddddg"), List.of("dgggggggggg"))
                ),
                Arguments.of(
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(
                                List.of("bat"),
                                List.of("tan", "nat"),
                                List.of("eat", "tea", "ate")
                        )
                )
        );
    }
}
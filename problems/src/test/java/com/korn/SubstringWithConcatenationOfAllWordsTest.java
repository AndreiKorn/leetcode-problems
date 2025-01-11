package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SubstringWithConcatenationOfAllWordsTest {
    @ParameterizedTest
    @MethodSource
    void findSubstring(String s, String[] words, List<Integer> expectedResult) {
        List<Integer> actualResult = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> findSubstring() {
        return Stream.of(
                Arguments.of("acbd", new String[]{"a", "b", "c"}, List.of(0)),
                Arguments.of("foobar", new String[]{"foo", "bar"}, List.of(0)),
                Arguments.of("barfoobar", new String[]{"foo", "bar"}, List.of(0, 3)),
                Arguments.of("barfoofoobar", new String[]{"foo", "bar"}, List.of(0, 6)),
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, List.of(0, 9)),
                Arguments.of("manbarfoothefoobarman", new String[]{"foo", "bar"}, List.of(3, 12)),
                Arguments.of("anbarfoothefoobarman", new String[]{"foo", "bar"}, List.of(2, 11)),
                Arguments.of("nbarfoothefoobarman", new String[]{"foo", "bar"}, List.of(1, 10)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, List.of()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, List.of(6, 9, 12)),
                Arguments.of(
                        "lingmindraboofooowingdingbarrwingmonkeypoundcake",
                        new String[]{"fooo", "barr", "wing", "ding", "wing"},
                        List.of(13)
                ),
                Arguments.of("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        );
    }
}
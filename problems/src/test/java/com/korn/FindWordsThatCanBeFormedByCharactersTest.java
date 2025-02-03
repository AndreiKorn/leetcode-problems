package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindWordsThatCanBeFormedByCharactersTest {
    @ParameterizedTest
    @MethodSource
    void countCharacters(String[] words, String chars, int expectedResult) {
        int actualResult = new FindWordsThatCanBeFormedByCharacters().countCharacters(words, chars);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> countCharacters() {
        return Stream.of(
                Arguments.of(new String[]{"cat", "bt", "hat", "tree"}, "", 0),
                Arguments.of(new String[]{}, "atach", 0),
                Arguments.of(new String[]{"atach"}, "atach", 5),
                Arguments.of(new String[]{"cat", "bt", "hat", "tree"}, "atach", 6),
                Arguments.of(new String[]{"cat", "bt", "hat", "tree"}, "atre", 0),
                Arguments.of(new String[]{"cat", "bt", "hat", "tree"}, "batrachee", 12),
                Arguments.of(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr", 10)
        );
    }
}
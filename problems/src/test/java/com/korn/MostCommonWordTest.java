package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MostCommonWordTest {
    @ParameterizedTest
    @MethodSource
    void mostCommonWord(String paragraph, String[] banned, String expectedResult) {
        String actualResult = new MostCommonWord().mostCommonWord(paragraph, banned);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> mostCommonWord() {
        return Stream.of(
                Arguments.of(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",
                        new String[]{"hit"},
                        "ball"
                ),
                Arguments.of(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",
                        new String[]{},
                        "hit"
                ),
                Arguments.of(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",
                        new String[]{"hit", "ball"},
                        "bob"
                ),
                Arguments.of(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",
                        new String[]{"hit", "ball", "bob"},
                        "a"
                ),
                Arguments.of("a", new String[]{}, "a"),
                Arguments.of("Bob. hIt, baLl", new String[]{"bob", "hit"}, "ball"),
                Arguments.of("Bob. hIt, bob, HIT, BOB, baLl, hit", new String[]{}, "bob"),
                Arguments.of("Bob. hIt, bob, HIT, BOB, baLl, hit", new String[]{"bob"}, "hit"),
                Arguments.of("Bob. hIt, bob, HIT, BOB, baLl, hit", new String[]{"bob", "hit"}, "ball")
        );
    }
}
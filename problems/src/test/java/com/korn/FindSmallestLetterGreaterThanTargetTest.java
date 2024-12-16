package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindSmallestLetterGreaterThanTargetTest {
    @ParameterizedTest
    @MethodSource
    void nextGreatestLetter(char[] letters, char target, char expectedResult) {
        char actualResult = new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> nextGreatestLetter() {
        return Stream.of(
                Arguments.of(new char[]{'c', 'f'}, 'a', 'c'),
                Arguments.of(new char[]{'c', 'f'}, 'c', 'f'),
                Arguments.of(new char[]{'a', 'c', 'c'}, 'a', 'c'),
                Arguments.of(new char[]{'a', 'c', 'c'}, 'c', 'a'),
                Arguments.of(new char[]{'a', 'c', 'f'}, 'z', 'a'),
                Arguments.of(new char[]{'a', 'a', 'a'}, 'b', 'a'),
                Arguments.of(
                        new char[]{
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
                        },
                        'z',
                        'a'
                ),
                Arguments.of(
                        new char[]{
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
                        },
                        'a',
                        'b'
                ),
                Arguments.of(
                        new char[]{
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
                        },
                        'u',
                        'v'
                )
        );
    }
}
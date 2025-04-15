package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexIITest {
    @ParameterizedTest
    @MethodSource
    void hIndex(int[] citations, int expectedResult) {
        int actualResult = new HIndexII().hIndex(citations);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> hIndex() {
        return Stream.of(
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{1, 2, 100}, 2),
                Arguments.of(new int[]{0, 1, 3, 5, 6}, 3),
                Arguments.of(new int[]{0, 1, 1, 5, 6}, 2),
                Arguments.of(new int[]{0, 1, 1, 1, 6}, 1)
        );
    }
}
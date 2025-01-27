package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueNumberOfOccurrencesTest {
    @ParameterizedTest
    @MethodSource
    void uniqueOccurrences(int[] arr, boolean expectedResult) {
        boolean actualResult = new UniqueNumberOfOccurrences().uniqueOccurrences(arr);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> uniqueOccurrences() {
        return Stream.of(
                Arguments.of(new int[]{1}, true),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{1, 2, 2}, true),
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3}, true),
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3, 3}, false),
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3, 3, 3, 3, 3, 3}, true),
                Arguments.of(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true)
        );
    }
}
package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {
    @ParameterizedTest
    @MethodSource
    void removeDuplicates(int[] inputNums, int[] expectedNums, int expectedLength) {
        int actualLength = new RemoveDuplicatesFromSortedArray().removeDuplicates(inputNums);

        assertThat(actualLength).isEqualTo(expectedLength);
        for (int i = 0; i < expectedNums.length; i++) {
            assertThat(inputNums[i]).isEqualTo(expectedNums[i]);
        }
    }

    static Stream<Arguments> removeDuplicates() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{1}, 1),
                Arguments.of(new int[]{1, 1}, new int[]{1}, 1),
                Arguments.of(new int[]{-100, 100}, new int[]{-100, 100}, 2),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 1, 2, 3}, 4),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1}, 1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2}, new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2}, new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2}, new int[]{1, 2}, 2)
        );
    }
}
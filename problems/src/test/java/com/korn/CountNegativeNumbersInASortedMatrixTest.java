package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountNegativeNumbersInASortedMatrixTest {
    @ParameterizedTest
    @MethodSource
    void countNegatives(int[][] grid, int expectedResult) {
        int actualResult = new CountNegativeNumbersInASortedMatrix().countNegatives(grid);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> countNegatives() {
        return Stream.of(
                Arguments.of(new int[][]{{1}}, 0),
                Arguments.of(new int[][]{{0}}, 0),
                Arguments.of(new int[][]{{-1}}, 1),
                Arguments.of(new int[][]{{3, 2}, {1, 0}}, 0),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}}, 9),
                Arguments.of(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}, 8)
        );
    }
}
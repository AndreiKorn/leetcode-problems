package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CheckIfItIsAStraightLineTest {
    @ParameterizedTest
    @MethodSource
    void checkStraightLine(int[][] coordinates, boolean expectedResult) {
        boolean actualResult = new CheckIfItIsAStraightLine().checkStraightLine(coordinates);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> checkStraightLine() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {100, -1}}, true),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}, true),
                Arguments.of(new int[][]{{3, 4}, {6, 7}, {2, 3}, {4, 5}, {1, 2}, {5, 6}}, true),
                Arguments.of(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}, false),
                Arguments.of(new int[][]{{0, 1}, {0, 1}, {0, 1}}, true),
                Arguments.of(new int[][]{{0, 1}, {1, 1}, {0, -1}}, false),
                Arguments.of(new int[][]{{0, 0}, {0, 1}, {0, -1}}, true),
                Arguments.of(new int[][]{{0, 0}, {1, 1}, {0, -1}}, false),
                Arguments.of(new int[][]{{5, 1}, {8, 1}, {16, 1}}, true),
                Arguments.of(new int[][]{{5, 1}, {8, 1}, {16, -1}}, false),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}}, true)
        );
    }
}
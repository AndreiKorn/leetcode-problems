package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DungeonGameTest {
    @ParameterizedTest
    @MethodSource
    void calculateMinimumHP(int[][] dungeon, int expectedResult) {
        int actualResult = new DungeonGame().calculateMinimumHP(dungeon);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> calculateMinimumHP() {
        return Stream.of(
                Arguments.of(new int[][]{{0}}, 1),
                Arguments.of(new int[][]{{0}}, 1),
                Arguments.of(new int[][]{{1}}, 1),
                Arguments.of(new int[][]{{5}}, 1),
                Arguments.of(new int[][]{{-1}}, 2),
                Arguments.of(new int[][]{{-5}}, 6),
                Arguments.of(new int[][]{{1, 5}, {8, 3}}, 1),
                Arguments.of(new int[][]{{-1, -5}, {-8, -3}}, 10),
                Arguments.of(new int[][]{{1, -5}, {-8, 3}}, 5),
                Arguments.of(new int[][]{{0, 0}, {0, 0}}, 1),
                Arguments.of(new int[][]{{-2, 4, 13, -7, -1, 9, -22}}, 7),
                Arguments.of(new int[][]{{-2}, {4}, {13}, {-7}, {-1}, {9}, {-22}}, 7),
                Arguments.of(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, 7),
                Arguments.of(new int[][]{{-2, -3, 3, -4}, {-5, -10, 1, 1}, {10, 30, -5, -2}}, 6),
                Arguments.of(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -60}}, 28),
                Arguments.of(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, 60}}, 6)
        );
    }
}
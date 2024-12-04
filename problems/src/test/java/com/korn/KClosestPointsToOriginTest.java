package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class KClosestPointsToOriginTest {
    @ParameterizedTest
    @MethodSource
    void kClosest(int[][] points, int k, int[][] expectedResult) {
        int[][] actualResult = new KClosestPointsToOrigin().kClosest(points, k);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> kClosest() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
                Arguments.of(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}}),
                Arguments.of(new int[][]{{-2, -2}, {3, 3}}, 1, new int[][]{{-2, -2}}),
                Arguments.of(
                        new int[][]{{-2, -2}, {0, 0}, {28, -1}, {5, 4}, {3, 0}},
                        3,
                        new int[][]{{-2, -2}, {0, 0}, {3, 0}}
                )
        );
    }
}
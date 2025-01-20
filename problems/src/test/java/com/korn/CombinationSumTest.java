package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {
    @ParameterizedTest
    @MethodSource
    void combinationSum(int[] candidates, int target, List<List<Integer>> expectedResult) {
        List<List<Integer>> actualResult = new CombinationSum().combinationSum(candidates, target);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> combinationSum() {
        return Stream.of(
                Arguments.of(new int[]{}, 3, List.of()),
                Arguments.of(new int[]{2}, 1, List.of()),
                Arguments.of(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
                Arguments.of(new int[]{2, 3, 5}, 8, List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
                Arguments.of(
                        new int[]{2, 3, 6, 7},
                        30,
                        List.of(
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 6),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 7),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 6),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 6, 6),
                                List.of(2, 2, 2, 2, 2, 2, 2, 2, 7, 7),
                                List.of(2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 7),
                                List.of(2, 2, 2, 2, 2, 2, 2, 3, 6, 7),
                                List.of(2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3),
                                List.of(2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 6),
                                List.of(2, 2, 2, 2, 2, 2, 3, 3, 6, 6),
                                List.of(2, 2, 2, 2, 2, 2, 6, 6, 6),
                                List.of(2, 2, 2, 2, 2, 3, 3, 7, 7),
                                List.of(2, 2, 2, 2, 2, 6, 7, 7),
                                List.of(2, 2, 2, 2, 3, 3, 3, 3, 3, 7),
                                List.of(2, 2, 2, 2, 3, 3, 3, 6, 7),
                                List.of(2, 2, 2, 2, 3, 6, 6, 7),
                                List.of(2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3),
                                List.of(2, 2, 2, 3, 3, 3, 3, 3, 3, 6),
                                List.of(2, 2, 2, 3, 3, 3, 3, 6, 6),
                                List.of(2, 2, 2, 3, 3, 6, 6, 6),
                                List.of(2, 2, 2, 3, 7, 7, 7),
                                List.of(2, 2, 2, 6, 6, 6, 6),
                                List.of(2, 2, 3, 3, 3, 3, 7, 7),
                                List.of(2, 2, 3, 3, 6, 7, 7),
                                List.of(2, 2, 6, 6, 7, 7),
                                List.of(2, 3, 3, 3, 3, 3, 3, 3, 7),
                                List.of(2, 3, 3, 3, 3, 3, 6, 7),
                                List.of(2, 3, 3, 3, 6, 6, 7),
                                List.of(2, 3, 6, 6, 6, 7),
                                List.of(2, 7, 7, 7, 7),
                                List.of(3, 3, 3, 3, 3, 3, 3, 3, 3, 3),
                                List.of(3, 3, 3, 3, 3, 3, 3, 3, 6),
                                List.of(3, 3, 3, 3, 3, 3, 6, 6),
                                List.of(3, 3, 3, 3, 6, 6, 6),
                                List.of(3, 3, 3, 7, 7, 7),
                                List.of(3, 3, 6, 6, 6, 6),
                                List.of(3, 6, 7, 7, 7),
                                List.of(6, 6, 6, 6, 6)
                        )
                )
        );
    }
}
package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumIITest {
    @ParameterizedTest
    @MethodSource
    void combinationSum2(int[] candidates, int target, List<List<Integer>> expectedResult) {
        List<List<Integer>> actualResult = new CombinationSumII().combinationSum2(candidates, target);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> combinationSum2() {
        return Stream.of(
                Arguments.arguments(new int[]{}, 1, List.of()),
                Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 3, List.of(List.of(1, 1, 1))),
                Arguments.arguments(new int[]{2, 3, 6, 7}, 356, List.of()),
                Arguments.of(
                        new int[]{1, 1, 2, 5, 6, 7, 10},
                        8,
                        List.of(
                                List.of(1, 1, 6),
                                List.of(1, 2, 5),
                                List.of(1, 7),
                                List.of(2, 6)
                        )
                ),
                Arguments.of(new int[]{2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5))),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        30,
                        List.of(
                                List.of(
                                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                        1, 1, 1, 1
                                )
                        )
                )
        );
    }
}
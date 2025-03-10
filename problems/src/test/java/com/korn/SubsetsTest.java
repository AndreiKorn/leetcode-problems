package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetsTest {
    @ParameterizedTest
    @MethodSource
    void subsets(int[] nums, List<List<Integer>> expectedResult) {
        List<List<Integer>> actualResult = new Subsets().subsets(nums);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> subsets() {
        return Stream.of(
                Arguments.of(new int[]{}, List.of(List.of())),
                Arguments.of(new int[]{1}, List.of(List.of(), List.of(1))),
                Arguments.of(new int[]{2}, List.of(List.of(), List.of(2))),
                Arguments.of(new int[]{1, 2}, List.of(List.of(), List.of(1), List.of(2), List.of(1, 2))),
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(
                                List.of(),
                                List.of(1),
                                List.of(2),
                                List.of(3),
                                List.of(1, 2),
                                List.of(1, 3),
                                List.of(2, 3),
                                List.of(1, 2, 3)
                        )
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        List.of(
                                List.of(),
                                List.of(1),
                                List.of(2),
                                List.of(3),
                                List.of(4),
                                List.of(1, 2),
                                List.of(1, 3),
                                List.of(1, 4),
                                List.of(2, 3),
                                List.of(2, 4),
                                List.of(3, 4),
                                List.of(1, 2, 3),
                                List.of(1, 2, 4),
                                List.of(1, 3, 4),
                                List.of(2, 3, 4),
                                List.of(1, 2, 3, 4)
                        )
                )
        );
    }
}
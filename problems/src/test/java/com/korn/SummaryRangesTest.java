package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRangesTest {
    @ParameterizedTest
    @MethodSource
    void summaryRanges(int[] nums, List<String> expectedResult) {
        List<String> actualResult = new SummaryRanges().summaryRanges(nums);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> summaryRanges() {
        return Stream.of(
                Arguments.of(new int[]{}, List.of()),
                Arguments.of(new int[]{0}, List.of("0")),
                Arguments.of(new int[]{0, 2, 4, 7}, List.of("0", "2", "4", "7")),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, List.of("0->9"))
        );
    }
}
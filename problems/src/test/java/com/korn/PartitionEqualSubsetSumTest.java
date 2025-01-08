package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionEqualSubsetSumTest {
    @ParameterizedTest
    @MethodSource
    void canPartition(int[] nums, boolean expectedResult) {
        boolean actualResult = new PartitionEqualSubsetSum().canPartition(nums);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> canPartition() {
        return Stream.of(
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{3, 3, 3}, false),
                Arguments.of(new int[]{3, 3, 3, 3}, true),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
                Arguments.of(new int[]{1, 2, 3, 4}, true),
                Arguments.of(new int[]{4, 3, 2, 1}, true),
                Arguments.of(new int[]{1, 5, 11, 5}, true)
        );
    }
}
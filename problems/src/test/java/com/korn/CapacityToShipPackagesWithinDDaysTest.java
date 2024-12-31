package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CapacityToShipPackagesWithinDDaysTest {
    @ParameterizedTest
    @MethodSource
    void shipWithinDays(int[] weights, int days, int expectedResult) {
        int actualResult = new CapacityToShipPackagesWithinDDays().shipWithinDays(weights, days);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> shipWithinDays() {
        return Stream.of(
                Arguments.of(new int[]{3}, 1, 3),
                Arguments.of(new int[]{3}, 1, 3),
                Arguments.of(new int[]{3}, 5, 3),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 5, 5),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 1, 25),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 3, 10),
                Arguments.of(new int[]{1, 2, 3, 1, 1}, 4, 3),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 15),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 10),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, 55),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 5, 15),
                Arguments.of(new int[]{8, 5, 1, 2, 6, 4, 3, 8, 12, 3}, 3, 21),
                Arguments.of(new int[]{8, 5, 1, 2, 6, 4, 3, 8, 12, 3}, 12, 12),
                Arguments.of(new int[]{8, 5, 1, 2, 6, 4, 3, 8, 12, 3}, 1, 52),
                Arguments.of(new int[]{3, 2, 2, 4, 1, 4}, 3, 6)
        );
    }
}
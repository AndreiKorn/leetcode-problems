package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllNumbersDisappearedInAnArrayTest {
    @ParameterizedTest
    @MethodSource
    void findDisappearedNumbers(int[] input, List<Integer> expectedResult) {
        List<Integer> actualResult = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> findDisappearedNumbers() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)),
                Arguments.of(new int[]{1, 1}, List.of(2)),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, List.of()),
                Arguments.of(new int[]{}, List.of()),
                Arguments.of(new int[]{4, 3, 4, 3, 4, 3, 3, 4}, List.of(1, 2, 5, 6, 7, 8))
        );
    }
}
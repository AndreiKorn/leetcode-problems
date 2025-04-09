package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PascalsTriangleIITest {
    @ParameterizedTest
    @MethodSource
    void getRow(int rowIndex, List<Integer> expectedResult) {
        List<Integer> actualResult = new PascalsTriangleII().getRow(rowIndex);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> getRow() {
        return Stream.of(
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1, 1)),
                Arguments.of(2, List.of(1, 2, 1)),
                Arguments.of(3, List.of(1, 3, 3, 1)),
                Arguments.of(4, List.of(1, 4, 6, 4, 1)),
                Arguments.of(5, List.of(1, 5, 10, 10, 5, 1))
        );
    }
}
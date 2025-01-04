package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UniquePathsTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "1, 2, 1",
            "2, 1, 1",
            "2, 2, 2",
            "3, 2, 3",
            "2, 3, 3",
            "3, 3, 6",
            "3, 7, 28",
            "7, 3, 28",
            "1, 100, 1",
            "100, 1, 1",
    })
    void uniquePaths(int m, int n, long expectedResult) {
        long actualResult = new UniquePaths().uniquePaths(m, n);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
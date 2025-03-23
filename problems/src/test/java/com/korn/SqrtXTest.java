package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SqrtXTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 1",
            "4, 2",
            "6, 2",
            "8, 2",
            "9, 3",
            "10, 3",
            "2147395599, 46339",
            "2147483647, 46340",
    })
    void mySqrt(int x, int expectedResult) {
        int actualResult = new SqrtX().mySqrt(x);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
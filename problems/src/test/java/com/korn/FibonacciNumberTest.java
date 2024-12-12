package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciNumberTest {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34",
            "10, 55",
            "11, 89",
            "12, 144",
            "30, 832040",
    })
    void fib(int n, int expectedResult) {
        int actualResult = new FibonacciNumber().fib(n);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPerfectSquareTest {
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,false",
            "3,false",
            "4,true",
            "7,false",
            "9,true",
            "14,false",
            "16,true",
            "808201,true",
            "2147395599,false",
            "2147395600,true",
            "2147395601,false",
            "2147483647,false",
    })
    void isPerfectSquare(int num, boolean expectedResult) {
        boolean actualResult = new ValidPerfectSquare().isPerfectSquare(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
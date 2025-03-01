package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumScoreAfterSplittingAStringTest {
    @ParameterizedTest
    @CsvSource({
            "10,0",
            "01,2",
            "1111,3",
            "1100,1",
            "0011,4",
            "00000,4",
            "00111,5",
            "011101,5",
    })
    void maxScore(String s, int expectedResult) {
        int actualResult = new MaximumScoreAfterSplittingAString().maxScore(s);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
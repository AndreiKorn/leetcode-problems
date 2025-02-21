package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LongestRepeatingSubstringTest {
    @ParameterizedTest
    @CsvSource({
            ", 0",
            "a, 0",
            "aa, 1",
            "abab, 2",
            "abcd, 0",
            "abbaba, 2",
            "aabcaabdaab, 3",
            "aaaabasa, 3",
            "aaaaaaaaa, 9",
            "aaabaabbbaaabaabbaabbbabbbaaaabbaaaaaabbbaabbbbbbbbbaaaabbabbaba, 10"
    })
    void longestRepeatingSubstring(String s, int expectedResult) {
        int actualResult = new LongestRepeatingSubstring().longestRepeatingSubstring(s);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
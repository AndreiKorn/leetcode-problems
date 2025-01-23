package com.korn;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidWordAbbreviationTest {
    @ParameterizedTest
    @CsvSource({
            "internationalization, i12iz4n, true",
            "substitution, s10n, true",
            "substitution, sub4u4, true",
            "substitution, sub4u5, false",
            "substitution, 12, true",
            "substitution, 11, false",
            "substitution, 13, false",
            "substitution, su3i1u2on, true",
            "substitution, substitution, true",
            "substitution, substitutions, false",
            "substitution, s55n, false",
            "substitution, s010n, false",
            "substitution, s0ubstitution, false",
            "apple, a2e, false",
            "abbde, a1b1e, true",
            "abbde, a1b01e, false",
    })
    void validWordAbbreviation(String word, String abbr, boolean expectedResult) {
        boolean actualResult = new ValidWordAbbreviation().validWordAbbreviation(word, abbr);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
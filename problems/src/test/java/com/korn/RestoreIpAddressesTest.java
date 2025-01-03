package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RestoreIpAddressesTest {
    @ParameterizedTest
    @MethodSource
    void restoreIpAddresses(String s, List<String> expectedResult) {
        List<String> actualResult = new RestoreIpAddresses().restoreIpAddresses(s);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> restoreIpAddresses() {
        return Stream.of(
                Arguments.of("111", List.of()),
                Arguments.of("0000", List.of("0.0.0.0")),
                Arguments.of("1111", List.of("1.1.1.1")),
                Arguments.of(
                        "101023",
                        List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")
                ),
                Arguments.of(
                        "25252525",
                        List.of(
                                "25.25.25.25",
                                "25.25.252.5",
                                "25.252.5.25",
                                "25.252.52.5",
                                "252.5.25.25",
                                "252.5.252.5",
                                "252.52.5.25",
                                "252.52.52.5"
                        )
                ),
                Arguments.of(
                        "250252525",
                        List.of("250.25.25.25", "250.25.252.5", "250.252.5.25", "250.252.52.5")
                ),
                Arguments.of("255255255255", List.of("255.255.255.255")),
                Arguments.of("25525511135", List.of("255.255.11.135", "255.255.111.35")),
                Arguments.of("25525525625", List.of()),
                Arguments.of("1251251251251", List.of()),
                Arguments.of("351120120120", List.of())
        );
    }
}
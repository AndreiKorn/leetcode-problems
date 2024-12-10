package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfRecentCallsTest {
    @ParameterizedTest
    @MethodSource
    void ping(int[] requests, int[] expectedResponses) {
        NumberOfRecentCalls.RecentCounter recentCounter = new NumberOfRecentCalls.RecentCounter();
        int[] actualResponses = new int[requests.length];

        for (int i = 0; i < requests.length; i++) {
            actualResponses[i] = recentCounter.ping(requests[i]);
        }

        assertThat(actualResponses).isEqualTo(expectedResponses);
    }

    static Stream<Arguments> ping() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 3000}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 3001}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 3002}, new int[]{1, 1}),
                Arguments.of(new int[]{1, 3002, 6000}, new int[]{1, 1, 2}),
                Arguments.of(new int[]{1, 100, 3001, 3002}, new int[]{1, 2, 3, 3})
        );
    }
}
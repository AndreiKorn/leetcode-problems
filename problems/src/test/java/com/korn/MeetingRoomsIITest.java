package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingRoomsIITest {
    @ParameterizedTest
    @MethodSource
    void minMeetingRooms(int[][] intervals, int expectedResult) {
        int actualResult = new MeetingRoomsII().minMeetingRooms(intervals);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> minMeetingRooms() {
        return Stream.of(
                Arguments.of(new int[][]{{5, 12}}, 1),
                Arguments.of(new int[][]{{0, 5}, {50, 60}, {10, 15}, {15, 20}, {5, 10}}, 1),
                Arguments.of(new int[][]{{0, 1}, {0, 5}, {0, 10}, {0, 20}, {0, 30}}, 5),
                Arguments.of(new int[][]{{0, 30}, {2, 18}, {5, 10}, {1, 29}, {3, 6}}, 5),
                Arguments.of(new int[][]{{0, 30}, {5, 10}, {15, 20}}, 2),
                Arguments.of(new int[][]{{7, 10}, {2, 4}}, 1),
                Arguments.of(new int[][]{{0, 30}, {5, 10}, {10, 12}, {5, 20}, {15, 20}}, 3),
                Arguments.of(new int[][]{{12, 13}, {6, 11}, {2, 19}}, 2)
        );
    }
}
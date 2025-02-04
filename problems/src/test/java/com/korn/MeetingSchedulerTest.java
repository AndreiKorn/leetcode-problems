package com.korn;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingSchedulerTest {
    @ParameterizedTest
    @MethodSource
    void minAvailableDuration(int[][] slots1, int[][] slots2, int duration, List<Integer> expectedResult) {
        List<Integer> actualResult = new MeetingScheduler().minAvailableDuration(slots1, slots2, duration);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> minAvailableDuration() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{10, 50}, {60, 120}, {140, 210}},
                        new int[][]{{0, 5}, {250, 390}},
                        1,
                        List.of()
                ),
                Arguments.of(
                        new int[][]{{10, 50}, {60, 120}, {140, 210}},
                        new int[][]{{0, 20}, {60, 70}},
                        4,
                        List.of(10, 14)
                ),
                Arguments.of(
                        new int[][]{{10, 50}, {60, 120}, {140, 210}},
                        new int[][]{{0, 15}, {60, 70}},
                        8,
                        List.of(60, 68)
                ),
                Arguments.of(
                        new int[][]{{10, 50}, {60, 120}, {140, 210}},
                        new int[][]{{0, 15}, {60, 70}},
                        12,
                        List.of()
                ),
                Arguments.of(
                        new int[][]{
                                {216397070, 363167701},
                                {98730764, 158208909},
                                {441003187, 466254040},
                                {558239978, 678368334},
                                {683942980, 717766451}
                        },
                        new int[][]{
                                {50490609, 222653186},
                                {512711631, 670791418},
                                {730229023, 802410205},
                                {812553104, 891266775},
                                {230032010, 399152578}
                        },
                        456085,
                        List.of(98730764, 99186849)
                )
        );
    }
}
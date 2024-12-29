package com.korn;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class NextGreaterElementITest {
    @ParameterizedTest
    @MethodSource
    void nextGreaterElement(int[] nums1, int[] nums2, int[] expectedResult) {
        int[] actualResult = new NextGreaterElementI().nextGreaterElement(nums1, nums2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> nextGreaterElement() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{3}, new int[]{3}, new int[]{-1}),
                Arguments.of(new int[]{}, new int[]{5, 3, 1, 8, 4, 2, 6}, new int[]{}),
                Arguments.of(new int[]{3, 8, 2}, new int[]{5, 3, 1, 8, 4, 2, 6}, new int[]{8, -1, 6}),
                Arguments.of(new int[]{6}, new int[]{5, 3, 1, 8, 4, 2, 6}, new int[]{-1}),
                Arguments.of(new int[]{4, 5}, new int[]{4, 5, 3}, new int[]{5, -1}),
                Arguments.of(
                        new int[]{5, 3, 1, 8, 4, 2, 6},
                        new int[]{5, 3, 1, 8, 4, 2, 6},
                        new int[]{8, 8, 8, -1, 6, 6, -1}
                ),
                Arguments.of(
                        new int[]{6, 5, 4, 3, 2, 1},
                        new int[]{6, 5, 4, 3, 2, 1},
                        new int[]{-1, -1, -1, -1, -1, -1}
                ),
                Arguments.of(
                        new int[]{6, 5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{-1, 6, 5, 4, 3, 2}
                )
        );
    }
}
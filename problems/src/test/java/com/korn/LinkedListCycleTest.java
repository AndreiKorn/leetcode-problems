package com.korn;

import java.util.stream.Stream;

import com.korn.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.ListNodeUtils.createListWithCycle;
import static org.assertj.core.api.Assertions.assertThat;

class LinkedListCycleTest {
    @ParameterizedTest
    @MethodSource
    void hasCycle(ListNode head, boolean expectedResult) {
        boolean actualResult = new LinkedListCycle().hasCycle(head);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> hasCycle() {
        return Stream.of(
                Arguments.of(createListWithCycle(new int[]{}, -1), false),
                Arguments.of(createListWithCycle(new int[]{1}, -1), false),
                Arguments.of(createListWithCycle(new int[]{1}, 0), true),
                Arguments.of(createListWithCycle(new int[]{1, 2}, 0), true),
                Arguments.of(createListWithCycle(new int[]{1, 2}, 1), true),
                Arguments.of(createListWithCycle(new int[]{1, 2}, -1), false),
                Arguments.of(createListWithCycle(new int[]{3, 2, 0, -4}, -1), false),
                Arguments.of(createListWithCycle(new int[]{3, 2, 0, -4}, 0), true),
                Arguments.of(createListWithCycle(new int[]{3, 2, 0, -4}, 1), true),
                Arguments.of(createListWithCycle(new int[]{3, 2, 0, -4}, 2), true),
                Arguments.of(createListWithCycle(new int[]{3, 2, 0, -4}, 3), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, -1), false),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 0), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 1), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 5), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 6), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 8), true),
                Arguments.of(createListWithCycle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20}, 9), true)
        );
    }
}
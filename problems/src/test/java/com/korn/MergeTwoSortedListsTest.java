package com.korn;

import java.util.stream.Stream;

import com.korn.MergeTwoSortedLists.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {
    @ParameterizedTest
    @MethodSource
    void mergeTwoLists(ListNode list1, ListNode list2, ListNode expectedResult) {
        ListNode actualResult = new MergeTwoSortedLists().mergeTwoLists(list1, list2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> mergeTwoLists() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(createList(1), null, createList(1)),
                Arguments.of(null, createList(2), createList(2)),
                Arguments.of(createList(1, 2, 3), null, createList(1, 2, 3)),
                Arguments.of(createList(1, 2, 3), createList(1, 2, 3), createList(1, 1, 2, 2, 3, 3)),
                Arguments.of(createList(1, 2, 3), createList(4, 5, 6), createList(1, 2, 3, 4, 5, 6)),
                Arguments.of(createList(4, 5, 6), createList(1, 2, 3), createList(1, 2, 3, 4, 5, 6)),
                Arguments.of(createList(1, 4, 6), createList(2, 5, 8), createList(1, 2, 4, 5, 6, 8)),
                Arguments.of(createList(4, 8, 15, 42), createList(16, 23), createList(4, 8, 15, 16, 23, 42))
        );
    }

    private static ListNode createList(int... values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }
}
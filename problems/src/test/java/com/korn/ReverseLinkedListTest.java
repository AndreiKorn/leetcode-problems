package com.korn;

import java.util.stream.Stream;

import com.korn.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.ListNodeUtils.createList;
import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {
    @ParameterizedTest
    @MethodSource
    void reverseList(ListNode head, ListNode expectedResult) {
        ListNode actualResult = new ReverseLinkedList().reverseList(head);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> reverseList() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(createList(1), createList(1)),
                Arguments.of(createList(1, 2), createList(2, 1)),
                Arguments.of(createList(1, 2, 3, 4, 5), createList(5, 4, 3, 2, 1)),
                Arguments.of(createList(1, 3, 2, 5, 4), createList(4, 5, 2, 3, 1)),
                Arguments.of(createList(1, 2, 3, 4, 5, 6), createList(6, 5, 4, 3, 2, 1))
        );
    }
}
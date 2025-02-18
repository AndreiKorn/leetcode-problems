package com.korn;

import java.util.stream.Stream;

import com.korn.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.ListNodeUtils.createList;
import static org.assertj.core.api.Assertions.assertThat;

class SortListTest {
    @ParameterizedTest
    @MethodSource
    void sortList(ListNode head, ListNode expectedResult) {
        ListNode actualResult = new SortList().sortList(head);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> sortList() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(createList(-5), createList(-5)),
                Arguments.of(createList(4), createList(4)),
                Arguments.of(createList(4, 2, 1, 3), createList(1, 2, 3, 4)),
                Arguments.of(createList(-1, 5, 3, 4, 0), createList(-1, 0, 3, 4, 5)),
                Arguments.of(createList(1, 2, 3, 4, 5, 6, 7, 8, 9), createList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(createList(9, 8, 7, 6, 5, 4, 3, 2, 1), createList(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }
}
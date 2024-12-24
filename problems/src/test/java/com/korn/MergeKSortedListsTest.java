package com.korn;

import java.util.stream.Stream;

import com.korn.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.ListNodeUtils.createList;
import static com.korn.utils.ListNodeUtils.createLists;
import static org.assertj.core.api.Assertions.assertThat;

class MergeKSortedListsTest {
    @ParameterizedTest
    @MethodSource("mergeKLists")
    void mergeKListsWithDivideAndConquer(ListNode[] lists, ListNode expectedResult) {
        ListNode actualResult = new MergeKSortedLists().mergeKListsWithDivideAndConquer(lists);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("mergeKLists")
    void mergeKListsWithHeap(ListNode[] lists, ListNode expectedResult) {
        ListNode actualResult = new MergeKSortedLists().mergeKListsWithHeap(lists);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> mergeKLists() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(createLists(), null),
                Arguments.of(createLists(new int[][]{{0}}), createList(0)),
                Arguments.of(createLists(new int[][]{{1, 2, 3}}), createList(1, 2, 3)),
                Arguments.of(createLists(new int[][]{{3}, {1}, {5}}), createList(1, 3, 5)),
                Arguments.of(
                        createLists(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}}),
                        createList(1, 1, 2, 3, 4, 4, 5, 6)
                ),
                Arguments.of(createLists(new int[][]{{}, {}, {}}), createList()),
                Arguments.of(
                        createLists(new int[][]{{}, {1, 4, 5}, {}, {1, 3, 4}, {}, {2, 6}, {}}),
                        createList(1, 1, 2, 3, 4, 4, 5, 6)
                )
        );
    }
}
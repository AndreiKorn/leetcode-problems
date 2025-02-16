package com.korn;

import java.util.stream.Stream;

import com.korn.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.ListNodeUtils.createList;
import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {
    @ParameterizedTest
    @MethodSource
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expectedResult) {
        ListNode actualResult = new AddTwoNumbers().addTwoNumbers(l1, l2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> addTwoNumbers() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of(createList(1), null, createList(1)),
                Arguments.of(null, createList(1), createList(1)),
                Arguments.of(createList(0), createList(0), createList(0)),
                Arguments.of(createList(1), createList(1), createList(2)),
                Arguments.of(createList(9), createList(1), createList(0, 1)),
                Arguments.of(createList(1), createList(9), createList(0, 1)),
                Arguments.of(createList(2, 4, 3), createList(5, 6, 4), createList(7, 0, 8)),
                Arguments.of(createList(5, 6, 4), createList(2, 4, 3), createList(7, 0, 8)),
                Arguments.of(
                        createList(1, 2, 8, 6, 8, 9, 5, 3, 1),
                        createList(5, 6, 3, 1, 8, 2, 3),
                        createList(6, 8, 1, 8, 6, 2, 9, 3, 1)
                ),
                Arguments.of(
                        createList(5, 6, 3, 1, 8, 2, 3),
                        createList(1, 2, 8, 6, 8, 9, 5, 3, 1),
                        createList(6, 8, 1, 8, 6, 2, 9, 3, 1)
                ),
                Arguments.of(
                        createList(9, 9, 9, 9),
                        createList(9, 9, 9, 9, 9, 9, 9),
                        createList(8, 9, 9, 9, 0, 0, 0, 1)
                ),
                Arguments.of(
                        createList(9, 9, 9, 9),
                        createList(9, 9, 9, 9),
                        createList(8, 9, 9, 9, 1)
                ),
                Arguments.of(
                        createList(9, 9, 9, 9, 9, 9, 9),
                        createList(9, 9, 9, 9),
                        createList(8, 9, 9, 9, 0, 0, 0, 1)
                ),
                Arguments.of(
                        createList(9, 9, 9, 9),
                        createList(9, 9, 9, 9, 9, 9, 9),
                        createList(8, 9, 9, 9, 0, 0, 0, 1)
                )
        );
    }
}
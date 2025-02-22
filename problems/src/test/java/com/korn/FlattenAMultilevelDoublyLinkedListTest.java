package com.korn;

import java.util.stream.Stream;

import com.korn.model.MultiLevelDoublyLinkedNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class FlattenAMultilevelDoublyLinkedListTest {
    @ParameterizedTest
    @MethodSource
    void flatten(MultiLevelDoublyLinkedNode head, MultiLevelDoublyLinkedNode expectedResult) {
        MultiLevelDoublyLinkedNode actualResult = new FlattenAMultilevelDoublyLinkedList().flatten(head);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> flatten() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(node(5), node(5)),
                Arguments.of(node(5, node(8, node(1))), node(5, node(8, node(1)))),
                Arguments.of(node(5, node(8), node(1)), node(5, node(1, node(8)))),
                Arguments.of(node(5, null, node(1, null, node(6, null, node(9)))), node(5, node(1, node(6, node(9))))),
                Arguments.of(
                        node(
                                1,
                                node(
                                        2,
                                        node(
                                                3,
                                                node(
                                                        4,
                                                        node(
                                                                5,
                                                                node(6)
                                                        )
                                                ),
                                                node(
                                                        7,
                                                        node(
                                                                8,
                                                                node(
                                                                        9,
                                                                        node(
                                                                                10
                                                                        )
                                                                )
                                                        ),
                                                        node(
                                                                11,
                                                                node(12)
                                                        )
                                                )
                                        )
                                )
                        ),
                        node(
                                1,
                                node(
                                        2,
                                        node(
                                                3,
                                                node(
                                                        7,
                                                        node(
                                                                11,
                                                                node(
                                                                        12,
                                                                        node(
                                                                                8,
                                                                                node(
                                                                                        9,
                                                                                        node(
                                                                                                10,
                                                                                                node(
                                                                                                        4,
                                                                                                        node(
                                                                                                                5,
                                                                                                                node(6)
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private static MultiLevelDoublyLinkedNode node(int val) {
        return node(val, null);
    }

    private static MultiLevelDoublyLinkedNode node(
            int val,
            MultiLevelDoublyLinkedNode next
    ) {
        return node(val, next, null);
    }

    private static MultiLevelDoublyLinkedNode node(
            int val,
            MultiLevelDoublyLinkedNode next,
            MultiLevelDoublyLinkedNode child
    ) {
        return node(val, null, next, child);
    }

    public static MultiLevelDoublyLinkedNode node(
            int val,
            MultiLevelDoublyLinkedNode prev,
            MultiLevelDoublyLinkedNode next,
            MultiLevelDoublyLinkedNode child
    ) {
        MultiLevelDoublyLinkedNode newNode = new MultiLevelDoublyLinkedNode(
                val,
                prev,
                next,
                child
        );
//        if (prev != null) {
//            prev.next = newNode;
//        }
        if (next != null) {
            next.prev = newNode;
        }
        return newNode;
    }
}
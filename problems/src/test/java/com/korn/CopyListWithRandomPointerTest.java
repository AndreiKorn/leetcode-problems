package com.korn;

import java.util.stream.Stream;

import com.korn.model.NodeWithRandom;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.NodeWithRandomUtils.createList;
import static org.assertj.core.api.Assertions.assertThat;

class CopyListWithRandomPointerTest {
    @ParameterizedTest
    @MethodSource
    void copyRandomList(NodeWithRandom head, NodeWithRandom expectedResult) {
        NodeWithRandom actualResult = new CopyListWithRandomPointer().copyRandomList(head);
        assertThat(head).isNotEqualTo(actualResult);

        while (expectedResult != null) {
            assertThat(actualResult).isNotNull();
            assertThat(expectedResult.val).isEqualTo(actualResult.val);
            if (expectedResult.random != null) {
                assertThat(actualResult.random).isNotNull();
                assertThat(expectedResult.random.val).isEqualTo(actualResult.random.val);
            } else {
                assertThat(actualResult.random).isNull();
            }
            expectedResult = expectedResult.next;
            actualResult = actualResult.next;
        }
    }

    static Stream<Arguments> copyRandomList() {
        return Stream.of(
                createArguments(
                        new Integer[]{7, null},
                        new Integer[]{13, 0},
                        new Integer[]{11, 4},
                        new Integer[]{10, 2},
                        new Integer[]{1, 0}
                ),
                createArguments(
                        new Integer[]{1, 1},
                        new Integer[]{2, 1}
                ),
                createArguments(
                        new Integer[]{3, null},
                        new Integer[]{3, 0},
                        new Integer[]{3, null}
                ),
                createArguments(
                        new Integer[]{1, null},
                        new Integer[]{2, null},
                        new Integer[]{3, null}
                )
        );
    }

    private static Arguments createArguments(Integer[]... values) {
        return Arguments.of(createList(values), createList(values));
    }
}
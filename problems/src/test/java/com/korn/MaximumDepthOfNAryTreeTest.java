package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.NaryNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDepthOfNAryTreeTest {
    @ParameterizedTest
    @MethodSource
    void maxDepth(NaryNode root, int expectedResult) {
        int actualResult = new MaximumDepthOfNAryTree().maxDepth(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxDepth() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new NaryNode(1), 1),
                Arguments.of(new NaryNode(1, List.of(new NaryNode(2))), 2),
                Arguments.of(
                        new NaryNode(
                                1,
                                List.of(
                                        new NaryNode(
                                                2,
                                                List.of(
                                                        new NaryNode(3),
                                                        new NaryNode(4, List.of(new NaryNode(5)))
                                                )
                                        )
                                )
                        ),
                        4
                ),
                Arguments.of(
                        new NaryNode(
                                1,
                                List.of(
                                        new NaryNode(
                                                2,
                                                List.of(
                                                        new NaryNode(3),
                                                        new NaryNode(4, List.of(new NaryNode(5)))
                                                )
                                        ),
                                        new NaryNode(
                                                6,
                                                List.of(
                                                        new NaryNode(7),
                                                        new NaryNode(8, List.of(new NaryNode(9)))
                                                )
                                        )
                                )
                        ),
                        4
                ),
                Arguments.of(
                        new NaryNode(
                                1,
                                List.of(
                                        new NaryNode(
                                                2,
                                                List.of(
                                                        new NaryNode(3),
                                                        new NaryNode(4, List.of(new NaryNode(5)))
                                                )
                                        ),
                                        new NaryNode(
                                                6,
                                                List.of(
                                                        new NaryNode(7, List.of(new NaryNode(10))),
                                                        new NaryNode(8, List.of(new NaryNode(9)))
                                                )
                                        ),
                                        new NaryNode(
                                                11,
                                                List.of(
                                                        new NaryNode(12, List.of(new NaryNode(13))),
                                                        new NaryNode(4, List.of(new NaryNode(15)))
                                                )
                                        )
                                )
                        ),
                        4
                ),
                Arguments.of(
                        new NaryNode(
                                1,
                                List.of(
                                        new NaryNode(
                                                2,
                                                List.of(
                                                        new NaryNode(3),
                                                        new NaryNode(4, List.of(new NaryNode(5)))
                                                )
                                        ),
                                        new NaryNode(
                                                6,
                                                List.of(
                                                        new NaryNode(7, List.of(new NaryNode(10))),
                                                        new NaryNode(8, List.of(new NaryNode(9)))
                                                )
                                        ),
                                        new NaryNode(
                                                11,
                                                List.of(
                                                        new NaryNode(12, List.of(new NaryNode(13))),
                                                        new NaryNode(
                                                                4,
                                                                List.of(
                                                                        new NaryNode(15, List.of(new NaryNode(16)))
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        5
                )
        );
    }
}
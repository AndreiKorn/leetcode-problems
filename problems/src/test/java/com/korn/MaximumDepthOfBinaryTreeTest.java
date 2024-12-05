package com.korn;

import java.util.stream.Stream;

import com.korn.MaximumDepthOfBinaryTree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDepthOfBinaryTreeTest {
    @ParameterizedTest
    @MethodSource
    void maxDepth(TreeNode root, int expectedResult) {
        int actualResult = new MaximumDepthOfBinaryTree().maxDepth(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxDepth() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new TreeNode(1), 1),
                Arguments.of(new TreeNode(1, new TreeNode(2), null), 2),
                Arguments.of(new TreeNode(1, null, new TreeNode(3)), 2),
                Arguments.of(
                        new TreeNode(
                                1,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        new TreeNode(5)
                                ),
                                new TreeNode(
                                        3,
                                        new TreeNode(6),
                                        new TreeNode(7)
                                )
                        ),
                        3
                ),
                Arguments.of(
                        new TreeNode(
                                3,
                                new TreeNode(9),
                                new TreeNode(
                                        20,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                )
                        ),
                        3
                ),
                Arguments.of(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2)
                        ),
                        2
                ),
                Arguments.of(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(
                                        2,
                                        null,
                                        new TreeNode(
                                                3,
                                                null,
                                                new TreeNode(
                                                        4,
                                                        null,
                                                        new TreeNode(5)
                                                )
                                        )
                                )
                        ),
                        5
                )
        );
    }
}
package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePreorderTraversalTest {
    @ParameterizedTest
    @MethodSource
    void preorderTraversal(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actualResult = new BinaryTreePreorderTraversal().preorderTraversal(root);

        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    static Stream<Arguments> preorderTraversal() {
        return Stream.of(
                Arguments.of(null, List.of()),
                Arguments.of(new TreeNode(1), List.of(1)),
                Arguments.of(new TreeNode(1, new TreeNode(2), null), List.of(1, 2)),
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), List.of(1, 2)),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)), List.of(1, 2, 3)),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), List.of(1, 2, 3)),
                Arguments.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)), List.of(1, 2, 3)),
                Arguments.of(new TreeNode(1, new TreeNode(3), new TreeNode(2)), List.of(1, 3, 2)),
                Arguments.of(
                        new TreeNode(
                                1,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        new TreeNode(5)
                                ),
                                new TreeNode(3, null, new TreeNode(6))
                        ),
                        List.of(1, 2, 4, 5, 3, 6)
                )
        );
    }
}
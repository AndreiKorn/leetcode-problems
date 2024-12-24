package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorOfABinaryTreeTest {
    @ParameterizedTest
    @MethodSource
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode expectedResult) {
        TreeNode actualResult = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, p, q);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> lowestCommonAncestor() {
        return Stream.of(
                createArgument(new Integer[]{1, 2}, 0, 1, 0),
                createArgument(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 1, 2, 0),
                createArgument(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 1, 10, 1),
                createArgument(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, 9}, 1, 11, 0),
                createArgument(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, 9}, 6, 11, 2)
        );
    }

    private static Arguments createArgument(Integer[] values, int pIndex, int qIndex, int resultIndex) {
        TreeNode[] nodes = createTree(values);
        return Arguments.of(nodes[0], nodes[pIndex], nodes[qIndex], nodes[resultIndex]);
    }

    private static TreeNode[] createTree(Integer[] values) {
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = values[i] == null ? null : new TreeNode(values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] == null) {
                continue;
            }

            if (2 * i + 1 < values.length) {
                nodes[i].left = nodes[2 * i + 1];
            }

            if (2 * i + 2 < values.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }

        return nodes;
    }
}
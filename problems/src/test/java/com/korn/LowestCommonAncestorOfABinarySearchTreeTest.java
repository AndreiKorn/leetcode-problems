package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorOfABinarySearchTreeTest {
    @ParameterizedTest
    @MethodSource
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, TreeNode expectedResult) {
        TreeNode actualResult = new LowestCommonAncestorOfABinarySearchTree().lowestCommonAncestor(root, p, q);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> lowestCommonAncestor() {
        return Stream.of(
                createArguments(2, 1, 0, 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                createArguments(1, 2, 0, 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                createArguments(1, 4, 1, 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                createArguments(4, 1, 1, 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                createArguments(0, 1, 0, 2, 1)
        );
    }

    static Arguments createArguments(int firstIndex, int secondIndex, int resultIndex, Integer... values) {
        TreeNode[] tree = createTree(values);
        return Arguments.of(tree[0], tree[firstIndex], tree[secondIndex], tree[resultIndex]);
    }
}
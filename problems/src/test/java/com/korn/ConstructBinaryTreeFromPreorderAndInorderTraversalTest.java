package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    @ParameterizedTest
    @MethodSource
    void buildTree(int[] preorder, int[] inorder, TreeNode expectedResult) {
        TreeNode actualResult = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> buildTree() {
        return Stream.of(
                Arguments.of(new int[]{3}, new int[]{3}, createTree(3)[0]),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}, createTree(1, 2)[0]),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}, createTree(1, null, 2)[0]),
                Arguments.of(new int[]{3, 2, 1, 4}, new int[]{1, 2, 3, 4}, createTree(3, 2, 4, 1)[0]),
                Arguments.of(
                        new int[]{3, 9, 20, 15, 7},
                        new int[]{9, 3, 15, 20, 7},
                        createTree(3, 9, 20, null, null, 15, 7)[0]
                )
        );
    }
}
package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
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
                Arguments.of(createTree(1)[0], List.of(1)),
                Arguments.of(createTree(1, 2)[0], List.of(1, 2)),
                Arguments.of(createTree(1, null, 2)[0], List.of(1, 2)),
                Arguments.of(createTree(1, 2, 3)[0], List.of(1, 2, 3)),
                Arguments.of(createTree(1, 2, null, 3)[0], List.of(1, 2, 3)),
                Arguments.of(createTree(1, null, 2, null, null, 3)[0], List.of(1, 2, 3)),
                Arguments.of(createTree(1, 3, 2)[0], List.of(1, 3, 2)),
                Arguments.of(createTree(1, 2, 3, 4, 5, null, 6)[0], List.of(1, 2, 4, 5, 3, 6))
        );
    }
}
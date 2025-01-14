package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class AllNodesDistanceKInBinaryTreeTest {
    @ParameterizedTest
    @MethodSource
    void distanceK(TreeNode root, TreeNode target, int k, List<Integer> expectedResult) {
        List<Integer> actualResult = new AllNodesDistanceKInBinaryTree().distanceK(root, target, k);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> distanceK() {
        return Stream.of(
                createArguments(new Integer[]{null}, 0, 2, List.of()),
                createArguments(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 1, 2, List.of(7, 4, 1)),
                createArguments(new Integer[]{1}, 0, 3, List.of()),
                createArguments(new Integer[]{0, 1, null, 3, 2}, 4, 1, List.of(1)),
                createArguments(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 0, 0, List.of(3)),
                createArguments(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 10, 2, List.of(5, 7)),
                createArguments(new Integer[]{3, 5, null, 6, null, 0}, 3, 2, List.of(3)),
                createArguments(new Integer[]{3, null, 5, null, null, 6, null, 0}, 2, 1, List.of(3, 6))
        );
    }

    private static Arguments createArguments(Integer[] values, int targetIndex, int k, List<Integer> expectedResult) {
        TreeNode[] tree = createTree(values);
        return Arguments.of(tree[0], tree[targetIndex], k, expectedResult);
    }
}
package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeMaximumPathSumTest {
    @ParameterizedTest
    @MethodSource
    void maxPathSum(TreeNode root, int expectedResult) {
        int actualResult = new BinaryTreeMaximumPathSum().maxPathSum(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> maxPathSum() {
        return Stream.of(
                createArguments(0, 0),
                createArguments(1, 1),
                createArguments(-5, -5),
                createArguments(6, 1, 2, 3),
                createArguments(8, 8, -2, -3),
                createArguments(6, 3, -15, -10, 6, -25, null, -1),
                createArguments(42, -10, 9, 20, null, null, 15, 7),
                createArguments(47, -10, 9, 20, 5, 13, 15, 7),
                createArguments(15, 10, -2, null, 4, null, null, null, 3)
        );
    }

    private static Arguments createArguments(int expectedResult, Integer... values) {
        return Arguments.of(createTree(values)[0], expectedResult);
    }
}
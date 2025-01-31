package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeToGreaterSumTreeTest {
    @ParameterizedTest
    @MethodSource
    void bstToGst(TreeNode root, TreeNode expectedResult) {
        TreeNode actualResult = new BinarySearchTreeToGreaterSumTree().bstToGst(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> bstToGst() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(createTree(1)[0], createTree(1)[0]),
                Arguments.of(createTree(0, null, 1)[0], createTree(1, null, 1)[0]),
                Arguments.of(
                        createTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)[0],
                        createTree(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8)[0]
                ),
                Arguments.of(
                        createTree(
                                1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null, 5
                        )[0],
                        createTree(
                                15, null, 14, null, null, null, 12, null, null, null, null, null, null, null, 9, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null, 5
                        )[0]
                ),
                Arguments.of(
                        createTree(
                                1,
                                2, null,
                                3, null, null, null,
                                4, null, null, null, null, null, null,
                                5, null, null, null, null, null, null, null, null, null, null, null, null
                        )[0],
                        createTree(
                                1,
                                3, null,
                                6, null, null, null,
                                10, null, null, null, null, null, null,
                                15, null, null, null, null, null, null, null, null, null, null, null, null
                        )[0]
                )
        );
    }
}
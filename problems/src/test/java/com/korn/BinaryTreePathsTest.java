package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePathsTest {
    @ParameterizedTest
    @MethodSource
    void binaryTreePaths(TreeNode root, List<String> expectedResult) {
        List<String> actualResult = new BinaryTreePaths().binaryTreePaths(root);

        assertThat(actualResult)
                .containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> binaryTreePaths() {
        return Stream.of(
                Arguments.of(null, List.of()),
                Arguments.of(new TreeNode(1), List.of("1")),
                Arguments.of(new TreeNode(1, new TreeNode(2), null), List.of("1->2")),
                Arguments.of(new TreeNode(1, null, new TreeNode(3)), List.of("1->3")),
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
                        List.of("1->2->4", "1->2->5", "1->3->6", "1->3->7")
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
                        List.of("3->9", "3->20->15", "3->20->7")
                ),
                Arguments.of(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2)
                        ),
                        List.of("1->2")
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
                        List.of("1->2->3->4->5")
                )
        );
    }
}
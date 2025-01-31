package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
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
                Arguments.of(createTree(1)[0], List.of("1")),
                Arguments.of(createTree(1, 2)[0], List.of("1->2")),
                Arguments.of(createTree(1, null, 3)[0], List.of("1->3")),
                Arguments.of(
                        createTree(1, 2, 3, 4, 5, 6, 7)[0],
                        List.of("1->2->4", "1->2->5", "1->3->6", "1->3->7")
                ),
                Arguments.of(createTree(3, 9, 20, null, null, 15, 7)[0], List.of("3->9", "3->20->15", "3->20->7")),
                Arguments.of(createTree(1, null, 2)[0], List.of("1->2")),
                Arguments.of(
                        createTree(
                                1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null, 5
                        )[0],
                        List.of("1->2->3->4->5")
                )
        );
    }
}
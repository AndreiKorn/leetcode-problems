package com.korn;

import java.util.List;
import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeRightSideViewTest {
    @ParameterizedTest
    @MethodSource
    void rightSideView(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actualResult = new BinaryTreeRightSideView().rightSideView(root);

        assertThat(actualResult)
                .containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    static Stream<Arguments> rightSideView() {
        return Stream.of(
                Arguments.of(null, List.of()),
                Arguments.of(createTree(1)[0], List.of(1)),
                Arguments.of(createTree(1, 2, 3)[0], List.of(1, 3)),
                Arguments.of(createTree(1, 2, null, 4)[0], List.of(1, 2, 4)),
                Arguments.of(createTree(1, null, 3, null, null, null, 5)[0], List.of(1, 3, 5)),
                Arguments.of(createTree(1, 2, 3, 4, 5, null, null, 6)[0], List.of(1, 3, 5, 6))
        );
    }
}

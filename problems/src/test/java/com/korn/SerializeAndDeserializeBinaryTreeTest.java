package com.korn;

import java.util.stream.Stream;

import com.korn.model.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.korn.utils.TreeNodeUtils.createTree;
import static org.assertj.core.api.Assertions.assertThat;

class SerializeAndDeserializeBinaryTreeTest {
    @ParameterizedTest
    @MethodSource
    void testSerializeAndDeserializeBinaryTree(TreeNode root) {
        SerializeAndDeserializeBinaryTree.Codec codec = new SerializeAndDeserializeBinaryTree.Codec();
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        assertThat(root).isEqualTo(deserialized);
    }

    static Stream<Arguments> testSerializeAndDeserializeBinaryTree() {
        return Stream.of(
                Arguments.of(new Object[]{null}),
                Arguments.of(createTree(1)[0]),
                Arguments.of(createTree(1, 2)[0]),
                Arguments.of(createTree(1, null, 3)[0]),
                Arguments.of(createTree(1, 2, 3, 4, 5, 6, 7)[0]),
                Arguments.of(createTree(3, 9, 20, null, null, 15, 7)[0]),
                Arguments.of(createTree(1, null, 2)[0]),
                Arguments.of(
                        createTree(
                                1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null, 5
                        )[0]
                )
        );
    }
}
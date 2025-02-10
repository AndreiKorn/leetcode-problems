package com.korn;

import java.util.HashMap;
import java.util.Map;

import com.korn.model.TreeNode;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private final Map<Integer, Integer> inorderIndicies = new HashMap<>();
    private int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndicies.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildSubTree(
            int[] preorder,
            int inorderStartIndex,
            int inorderEndIndex
    ) {
        if (inorderStartIndex > inorderEndIndex) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int rootInorderIndex = inorderIndicies.get(root.val);
        root.left = buildSubTree(preorder, inorderStartIndex, rootInorderIndex - 1);
        root.right = buildSubTree(preorder, rootInorderIndex + 1, inorderEndIndex);

        return root;
    }
}

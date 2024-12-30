package com.korn;

import java.util.ArrayList;
import java.util.List;

import com.korn.model.TreeNode;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal</a>
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    private void preorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);
    }
}

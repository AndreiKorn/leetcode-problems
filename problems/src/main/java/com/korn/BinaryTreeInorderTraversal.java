package com.korn;

import java.util.ArrayList;
import java.util.List;

import com.korn.model.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    private void inorderTraversal(List<Integer> nodes, TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(nodes, node.left);
        nodes.add(node.val);
        inorderTraversal(nodes, node.right);
    }
}

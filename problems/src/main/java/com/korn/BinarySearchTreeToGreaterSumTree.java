package com.korn;

import com.korn.model.TreeNode;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">Binary Search Tree to Greater Sum Tree</a>
 */
public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        calcSum(root, 0);
        return root;
    }

    private int calcSum(TreeNode node, int parentResult) {
        if (node == null) {
            return parentResult;
        }

        node.val = node.val + calcSum(node.right, parentResult);

        return calcSum(node.left, node.val);
    }
}

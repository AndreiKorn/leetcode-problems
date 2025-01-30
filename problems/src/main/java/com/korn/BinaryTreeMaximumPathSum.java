package com.korn;

import com.korn.model.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
 */
public class BinaryTreeMaximumPathSum {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumInner(root);

        return maxPathSum;
    }

    private int maxPathSumInner(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = Math.max(maxPathSumInner(root.left), 0);
        int rightMaxPathSum = Math.max(maxPathSumInner(root.right), 0);
        int sumThroughCurrent = root.val + leftMaxPathSum + rightMaxPathSum;

        maxPathSum = Math.max(maxPathSum, sumThroughCurrent);

        return Math.max(leftMaxPathSum, rightMaxPathSum) + root.val;
    }
}

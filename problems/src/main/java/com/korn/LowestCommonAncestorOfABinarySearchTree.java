package com.korn;

import com.korn.model.TreeNode;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest Common Ancestor of a Binary Search Tree</a>
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pIsToTheLeft = root.val > p.val;
        boolean qIsToTheLeft = root.val > q.val;
        if (pIsToTheLeft == qIsToTheLeft) {
            return lowestCommonAncestor(pIsToTheLeft ? root.left : root.right, p, q);
        }

        return root;
    }
}

package com.korn;

import java.util.ArrayList;
import java.util.List;

import com.korn.model.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addRightmost(result, root, 0);

        return result;
    }

    private void addRightmost(List<Integer> result, TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }

        if (currentDepth >= result.size()) {
            result.add(node.val);
        }

        addRightmost(result, node.right, currentDepth + 1);
        addRightmost(result, node.left, currentDepth + 1);
    }
}

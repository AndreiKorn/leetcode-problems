package com.korn;

import java.util.ArrayList;
import java.util.List;

import com.korn.model.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/binary-tree-paths/">Binary Tree Paths</a>
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        addPaths(result, new StringBuilder(), root);

        return result;
    }

    private void addPaths(List<String> result, StringBuilder pathToCurrent, TreeNode node) {
        if (node == null) {
            return;
        }

        int originalLength = pathToCurrent.length();
        pathToCurrent.append(node.val);

        if (isLeaf(node)) {
            result.add(pathToCurrent.toString());
        } else {
            pathToCurrent.append("->");
            addPaths(result, pathToCurrent, node.left);
            addPaths(result, pathToCurrent, node.right);
        }
        pathToCurrent.setLength(originalLength);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

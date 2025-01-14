package com.korn;

import java.util.ArrayList;
import java.util.List;

import com.korn.model.TreeNode;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">All Nodes Distance K in Binary Tree</a>
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        distanceToK(result, root, target, k);

        return result;
    }

    private int distanceToK(List<Integer> result, TreeNode node, TreeNode target, int k) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            addDescendants(result, node, 0, k);
            return 1;
        }

        int leftDistance = distanceToK(result, node.left, target, k);
        if (leftDistance > 0) {
            if (leftDistance == k) {
                result.add(node.val);
            } else {
                addDescendants(result, node.right, leftDistance + 1, k);
            }
            return leftDistance + 1;
        }

        int rightDistance = distanceToK(result, node.right, target, k);
        if (rightDistance > 0) {
            if (rightDistance == k) {
                result.add(node.val);
            } else {
                addDescendants(result, node.left, rightDistance + 1, k);
            }
            return rightDistance + 1;
        }

        return -1;
    }

    private void addDescendants(List<Integer> result, TreeNode node, int currentDistance, int k) {
        if (node == null || currentDistance > k) {
            return;
        }

        if (currentDistance == k) {
            result.add(node.val);
        } else {
            addDescendants(result, node.left, currentDistance + 1, k);
            addDescendants(result, node.right, currentDistance + 1, k);
        }
    }
}

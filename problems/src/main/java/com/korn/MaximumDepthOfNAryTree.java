package com.korn;

import com.korn.model.NaryNode;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of N-ary Tree</a>
 */
public class MaximumDepthOfNAryTree {
    public int maxDepth(NaryNode root) {
        if (root == null) {
            return 0;
        }

        int result = 1;
        for (NaryNode node : root.children) {
            result = Math.max(result, maxDepth(node) + 1);
        }
        return result;
    }
}

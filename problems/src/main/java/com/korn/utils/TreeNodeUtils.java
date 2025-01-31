package com.korn.utils;

import com.korn.model.TreeNode;

public class TreeNodeUtils {
    public static TreeNode[] createTree(Integer... values) {
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = values[i] == null ? null : new TreeNode(values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] == null) {
                continue;
            }

            if (2 * i + 1 < values.length) {
                nodes[i].left = nodes[2 * i + 1];
            }

            if (2 * i + 2 < values.length) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }

        return nodes;
    }
}

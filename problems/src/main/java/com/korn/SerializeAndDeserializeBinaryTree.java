package com.korn;

import java.util.Stack;

import com.korn.model.TreeNode;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
 */
public class SerializeAndDeserializeBinaryTree {
    public static class Codec {
        private static final String NULL_ELEMENT = "n";
        private static final String DELIMITER = ";";

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL_ELEMENT).append(DELIMITER);
            } else {
                sb.append(root.val).append(DELIMITER);
                serialize(root.left, sb);
                serialize(root.right, sb);
            }
        }

        public TreeNode deserialize(String data) {
            if (data.equals(NULL_ELEMENT)) {
                return null;
            }

            String[] elements = data.split(DELIMITER);
            Stack<TreeNode> nodes = new Stack<>();
            TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
            nodes.push(root);
            boolean isLeft = true;
            for (int i = 1; i < elements.length; i++) {
                String element = elements[i];
                if (element.equals(NULL_ELEMENT)) {
                    if (!isLeft) {
                        TreeNode current = nodes.pop();
                        while (!nodes.isEmpty() && nodes.peek().right == current) {
                            current = nodes.pop();
                        }
                    }
                    isLeft = false;
                } else {
                    TreeNode next = new TreeNode(Integer.parseInt(element));
                    if (isLeft) {
                        nodes.peek().left = next;
                    } else {
                        nodes.peek().right = next;
                    }
                    nodes.push(next);
                    isLeft = true;
                }
            }

            return root;
        }
    }
}

package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">Implement Trie (Prefix Tree)</a>
 */
public class ImplementTriePrefixTree {
    public static class Trie {
        private final TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                int currentCharIndex = word.charAt(i) - 'a';
                if (currentNode.nextNodes[currentCharIndex] == null) {
                    currentNode.nextNodes[currentCharIndex] = new TrieNode();
                }
                currentNode = currentNode.nextNodes[currentCharIndex];
            }
            currentNode.isWord = true;
        }

        public boolean search(String word) {
            TrieNode lastNodeInWord = findPrefix(word);
            return lastNodeInWord != null && lastNodeInWord.isWord;
        }

        public boolean startsWith(String prefix) {
            return findPrefix(prefix) != null;
        }

        private TrieNode findPrefix(String prefix) {
            TrieNode currentNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                int currentCharIndex = prefix.charAt(i) - 'a';
                if (currentNode.nextNodes[currentCharIndex] != null) {
                    currentNode = currentNode.nextNodes[currentCharIndex];
                } else {
                    return null;
                }
            }
            return currentNode;
        }

        private static class TrieNode {
            private final TrieNode[] nextNodes = new TrieNode[26];
            private boolean isWord = false;
        }
    }
}

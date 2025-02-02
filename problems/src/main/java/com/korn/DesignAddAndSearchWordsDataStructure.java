package com.korn;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">Design Add and Search Words Data Structure</a>
 */
public class DesignAddAndSearchWordsDataStructure {
    private final LetterNode root = new LetterNode();

    public void addWord(String word) {
        LetterNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char nextCharacter = word.charAt(i);
            currentNode = currentNode.childNodes.computeIfAbsent(nextCharacter, k -> new LetterNode());
            currentNode.isTerminal |= i == word.length() - 1;
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, LetterNode node) {
        boolean isLast = index == word.length() - 1;
        char currentElement = word.charAt(index);
        if (currentElement == '.') {
            if (isLast) {
                for (Map.Entry<Character, LetterNode> childNode : node.childNodes.entrySet()) {
                    if (childNode.getValue().isTerminal) {
                        return true;
                    }
                }
            } else {
                for (Map.Entry<Character, LetterNode> childNode : node.childNodes.entrySet()) {
                    if (search(word, index + 1, childNode.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            LetterNode currentNode = node.childNodes.get(currentElement);
            if (currentNode != null) {
                return isLast ? currentNode.isTerminal : search(word, index + 1, currentNode);
            } else {
                return false;
            }
        }
    }

    private static class LetterNode {
        boolean isTerminal = false;
        Map<Character, LetterNode> childNodes = new HashMap<>();
    }
}

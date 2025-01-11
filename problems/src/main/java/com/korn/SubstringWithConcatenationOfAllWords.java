package com.korn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/">Substring with Concatenation of All Words</a>
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> originalWordsCount = new HashMap<>();
        for (String word : words) {
            originalWordsCount.put(word, originalWordsCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        for (int i = 0; i < wordLength; i++) {
            findSubstringsWithSlidingWindow(originalWordsCount, result, s, i, wordLength);
        }

        return result;
    }

    private void findSubstringsWithSlidingWindow(
            Map<String, Integer> originalWordsCount,
            List<Integer> result,
            String s,
            int position,
            int wordLength
    ) {
        Map<String, Integer> leftWordsCount = new HashMap<>(originalWordsCount);
        int beginIndex = position;
        for (int i = position; i + wordLength < s.length() + 1; i += wordLength) {
            beginIndex = beginIndex == -1 ? i : beginIndex;

            String currentWord = s.substring(i, i + wordLength);
            if (originalWordsCount.containsKey(currentWord)) {
                while (!leftWordsCount.containsKey(currentWord)) {
                    String firstWord = s.substring(beginIndex, beginIndex + wordLength);
                    beginIndex += wordLength;
                    leftWordsCount.put(firstWord, leftWordsCount.getOrDefault(firstWord, 0) + 1);
                }

                decrementOrRemove(leftWordsCount, currentWord);
                if (leftWordsCount.isEmpty()) {
                    result.add(beginIndex);
                }
            } else {
                beginIndex = -1;
                leftWordsCount = new HashMap<>(originalWordsCount);
            }
        }
    }

    private void decrementOrRemove(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value > 1) {
            map.put(key, value - 1);
        } else {
            map.remove(key);
        }
    }
}

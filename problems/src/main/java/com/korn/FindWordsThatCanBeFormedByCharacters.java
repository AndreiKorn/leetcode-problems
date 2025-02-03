package com.korn;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsMap = toMap(chars);
        int result = 0;
        for (String word : words) {
            Map<Character, Integer> wordCharsMap = toMap(word);
            boolean possible = true;
            for (Map.Entry<Character, Integer> entry : wordCharsMap.entrySet()) {
                if (charsMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    possible = false;
                    break;
                }
            }
            result += (possible ? word.length() : 0);
        }
        return result;
    }

    private Map<Character, Integer> toMap(String chars) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char current = chars.charAt(i);
            result.put(current, result.getOrDefault(current, 0) + 1);
        }
        return result;
    }
}

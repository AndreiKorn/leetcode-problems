package com.korn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/group-anagrams/">Group Anagrams</a>
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();
        for (String str : strs) {
            String key = toKey(str);
            List<String> values = results.computeIfAbsent(key, k -> new ArrayList<>());
            values.add(str);
        }
        return new ArrayList<>(results.values());
    }

    private String toKey(String original) {
        int[] stats = new int[26];
        for (int i = 0; i < original.length(); i++) {
            stats[original.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stats.length; i++) {
            if (stats[i] > 0) {
                sb.append((char) (i + 'a')).append(stats[i]);
            }
        }
        return sb.toString();
    }
}

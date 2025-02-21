package com.korn;

import java.util.Arrays;

/**
 * Solution for <a href="https://leetcode.com/problems/longest-repeating-substring/">Longest Repeating Substring</a>
 */
public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        String[] suffixes = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            suffixes[i] = s.substring(i);
        }

        Arrays.sort(suffixes);

        int result = 0;
        for (int i = 0; i < suffixes.length - 1; i++) {
            int firstLength = suffixes[i].length();
            int secondLength = suffixes[i + 1].length();
            if (result >= firstLength || result >= secondLength) {
                continue;
            }

            int count = 0;
            int j = 0;
            while (j < Math.min(firstLength, secondLength) && suffixes[i].charAt(j) == suffixes[i + 1].charAt(j)) {
                count++;
                j++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}

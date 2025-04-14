package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), 0, s);
        return result;
    }

    private void partition(
            List<List<String>> result,
            List<String> tempResult,
            int position,
            String s
    ) {
        if (position >= s.length()) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for (int i = position; i < s.length(); i++) {
            if (isPalindrome(s, position, i)) {
                tempResult.add(s.substring(position, i + 1));
                partition(result, tempResult, i + 1, s);
                tempResult.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

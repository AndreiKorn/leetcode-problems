package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int[] answer = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int distance = expand(s, i, i);
            if (distance > answer[1] - answer[0] + 1) {
                answer[0] = i - distance / 2;
                answer[1] = i + distance / 2;
            }

            distance = expand(s, i, i + 1);
            if (distance > answer[1] - answer[0] + 1) {
                answer[0] = i - distance / 2 + 1;
                answer[1] = i + distance / 2;
            }
        }

        return s.substring(answer[0], answer[1] + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

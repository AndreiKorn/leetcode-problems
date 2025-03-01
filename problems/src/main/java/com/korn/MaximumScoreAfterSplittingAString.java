package com.korn;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">Maximum Score After Splitting a String</a>
 */
public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int leftScore = s.charAt(0) == '0' ? 1 : 0;
        int rightScore = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightScore++;
            }
        }
        int max = leftScore + rightScore;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                rightScore--;
            } else {
                leftScore++;
            }
            max = Math.max(max, leftScore + rightScore);
        }
        return max;
    }
}

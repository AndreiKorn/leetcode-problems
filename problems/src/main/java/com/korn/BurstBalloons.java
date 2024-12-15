package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/burst-balloons/">Burst Balloons</a>
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];

        return maxCoins(nums, memo, 0, n - 1);
    }

    private int maxCoins(int[] nums, int[][] memo, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        int result = 0;
        int leftValue = left - 1 >= 0 ? nums[left - 1] : 1;
        int rightValue = right + 1 < nums.length ? nums[right + 1] : 1;
        for (int i = left; i <= right; i++) {
            int current = leftValue * nums[i] * rightValue;
            int remaining = maxCoins(nums, memo, left, i - 1) + maxCoins(nums, memo, i + 1, right);
            result = Math.max(result, current + remaining);
        }

        memo[left][right] = result;

        return result;
    }
}

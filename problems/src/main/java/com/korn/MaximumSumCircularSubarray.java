package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">Maximum Sum Circular Subarray</a>
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int currentMinSum = nums[0];
        int minSum = currentMinSum;
        int currentMaxSum = currentMinSum;
        int maxSum = currentMinSum;
        int totalSum = currentMinSum;
        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(0, currentMinSum) + nums[i];
            minSum = Math.min(minSum, currentMinSum);

            totalSum += nums[i];
        }

        return totalSum == minSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}

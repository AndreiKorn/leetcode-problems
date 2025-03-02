package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        } else if (nums.length >= 3) {
            nums[nums.length - 3] += nums[nums.length - 1];
        }

        for (int i = nums.length - 4; i >= 0; i--) {
            nums[i] += Math.max(nums[i + 2], nums[i + 3]);
        }

        return Math.max(nums[0], nums[1]);
    }
}

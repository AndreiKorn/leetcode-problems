package com.korn;

import java.util.Arrays;

/**
 * Solution for <a href="https://leetcode.com/problems/two-sum-less-than-k/">Two Sum Less Than K</a>
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left < right) {
            int newSum = nums[left] + nums[right];
            if (newSum < k) {
                result = Math.max(result, newSum);
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}

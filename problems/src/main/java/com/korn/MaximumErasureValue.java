package com.korn;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-erasure-value/">Maximum Erasure Value</a>
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int currentSum = 0;
        int result = 0;
        Set<Integer> used = new HashSet<>();

        for (int current : nums) {
            if (used.contains(current)) {
                result = Math.max(result, currentSum);
                while (used.contains(current)) {
                    int toRemove = nums[left];
                    used.remove(toRemove);
                    currentSum -= toRemove;
                    left++;
                }
            }

            currentSum += current;
            used.add(current);
        }

        return Math.max(result, currentSum);
    }
}

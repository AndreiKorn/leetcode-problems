package com.korn;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/contiguous-array/">Contiguous Array</a>
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexBySum = new HashMap<>();
        int currentSum = 0;
        indexBySum.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i] == 1 ? 1 : -1;
            if (indexBySum.containsKey(currentSum)) {
                maxLength = Math.max(maxLength, i - indexBySum.get(currentSum));
            } else {
                indexBySum.put(currentSum, i);
            }
        }
        return maxLength;
    }
}

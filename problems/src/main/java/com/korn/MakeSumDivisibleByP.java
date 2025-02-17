package com.korn;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/make-sum-divisible-by-p/">Make Sum Divisible By P</a>
 */
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        int remainder = sum % p;
        if (remainder == 0) {
            return 0;
        }

        Map<Integer, Integer> indiciesBySum = new HashMap<>();
        indiciesBySum.put(0, -1);
        int currentSum = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int target = (currentSum - remainder + p) % p;

            if (indiciesBySum.containsKey(target)) {
                result = Math.min(result, i - indiciesBySum.get(target));
            }

            indiciesBySum.put(currentSum, i);
        }

        return result == nums.length ? -1 : result;
    }
}

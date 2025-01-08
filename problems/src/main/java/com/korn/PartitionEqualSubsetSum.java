package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Partition Equal Subset Sum</a>
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        return subSumExists(nums, memo, 0, sum / 2);
    }

    private boolean subSumExists(int[] nums, Boolean[][] memo, int index, int subSum) {
        if (subSum < 0 || index == nums.length) {
            return false;
        }

        if (subSum == 0) {
            return true;
        }

        if (memo[index][subSum] == null) {
            memo[index][subSum] = subSumExists(nums, memo, index + 1, subSum - nums[index])
                    || subSumExists(nums, memo, index + 1, subSum);
        }

        return memo[index][subSum];
    }
}

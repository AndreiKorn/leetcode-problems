package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> collector, List<Integer> temp, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            collector.add(new ArrayList<>(temp));
            backtrack(collector, temp, nums, i + 1);
            temp.removeLast();
        }
    }
}

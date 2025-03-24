package com.korn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, 0, 0, target);
        return result;
    }

    private void backtrack(
            List<List<Integer>> result,
            List<Integer> tempResult,
            int[] candidates,
            int position,
            int currentSum,
            int target
    ) {
        if (currentSum >= target) {
            if (currentSum == target) {
                result.add(new ArrayList<>(tempResult));
            }
            return;
        }

        for (int i = position; i < candidates.length && currentSum + candidates[i] <= target; i++) {
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempResult.add(candidates[i]);
            currentSum += candidates[i];
            backtrack(result, tempResult, candidates, i + 1, currentSum, target);
            tempResult.removeLast();
            currentSum -= candidates[i];
        }
    }
}

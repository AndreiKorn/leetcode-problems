package com.korn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new LinkedList<>(), 0, candidates, target, 0);

        return result;
    }

    private void backtrack(
            List<List<Integer>> result,
            LinkedList<Integer> tempResult,
            int currentSum,
            int[] candidates,
            int target,
            int firstIndex
    ) {
        if (currentSum == target) {
            result.add(new ArrayList<>(tempResult));
        }

        if (currentSum >= target) {
            return;
        }

        for (int i = firstIndex; i < candidates.length; i++) {
            tempResult.add(candidates[i]);
            backtrack(result, tempResult, currentSum + candidates[i], candidates, target, i);
            tempResult.removeLast();
        }
    }
}

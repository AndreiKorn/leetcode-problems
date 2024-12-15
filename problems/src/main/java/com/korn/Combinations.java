package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(
            List<List<Integer>> result,
            List<Integer> intermediateResult,
            int n,
            int k,
            int startingValue
    ) {
        if (intermediateResult.size() == k) {
            result.add(new ArrayList<>(intermediateResult));
            return;
        }
        
        int need = k - intermediateResult.size();
        int left = n - startingValue + 1;
        if (need > left) {
            return;
        }

        for (int i = startingValue; i <= n; i++) {
            intermediateResult.add(i);
            backtrack(result, intermediateResult, n, k, i + 1);
            intermediateResult.remove(intermediateResult.size() - 1);
        }
    }
}

package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/summary-ranges/">Summary Ranges</a>
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }

        int first = nums[0];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 < nums[i]) {
                result.add(getRange(first, nums[i - 1]));
                first = nums[i];
            }
        }
        result.add(getRange(first, nums[nums.length - 1]));

        return result;
    }

    private String getRange(int first, int last) {
        return first == last ? String.valueOf(first) : first + "->" + last;
    }
}

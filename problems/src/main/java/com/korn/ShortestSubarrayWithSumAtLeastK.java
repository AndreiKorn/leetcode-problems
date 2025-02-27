package com.korn;

import java.util.PriorityQueue;

import static java.util.Comparator.comparingLong;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/">Shortest Subarray with Sum at Least K</a>
 */
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<IndexWithSum> indiciesBySums =
                new PriorityQueue<>(comparingLong(indexWithSum -> indexWithSum.sum));
        long currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum >= k) {
                minLength = Math.min(minLength, i + 1);
            }
            while (!indiciesBySums.isEmpty() && currentSum - indiciesBySums.peek().sum >= k) {
                minLength = Math.min(minLength, i - indiciesBySums.poll().index);
            }
            indiciesBySums.offer(new IndexWithSum(i, currentSum));
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    record IndexWithSum(
            int index,
            long sum
    ) {
    }
}

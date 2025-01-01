package com.korn;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Solution for <a href="https://leetcode.com/problems/sliding-window-median/">Sliding Window Median</a>
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> smaller = new TreeSet<>(comparator);
        TreeSet<Integer> bigger = new TreeSet<>(comparator);
        for (int i = 0; i < k; i++) {
            smaller.add(i);
        }

        double[] result = new double[nums.length - k + 1];
        result[0] = calcMedian(nums, smaller, bigger, k % 2 == 0);
        for (int i = 0, j = 1; i < nums.length - k; i++, j++) {
            if (smaller.contains(i)) {
                smaller.remove(i);
            } else {
                bigger.remove(i);
            }

            bigger.add(i + k);
            smaller.add(bigger.pollFirst());

            result[j] = calcMedian(nums, smaller, bigger, k % 2 == 0);
        }

        return result;
    }

    private double calcMedian(int[] nums, TreeSet<Integer> smaller, TreeSet<Integer> bigger, boolean isEven) {
        balance(smaller, bigger);

        return isEven
                ? ((double) nums[smaller.last()] + nums[bigger.first()]) / 2
                : nums[bigger.first()];
    }

    private void balance(TreeSet<Integer> smaller, TreeSet<Integer> bigger) {
        while (smaller.size() > bigger.size()) {
            bigger.add(smaller.pollLast());
        }
    }
}

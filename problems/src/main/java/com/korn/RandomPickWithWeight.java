package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/random-pick-with-weight/">Random Pick with Weight</a>
 */
public class RandomPickWithWeight {
    private final int[] offsets;
    private final int rightBoundary;

    public RandomPickWithWeight(int[] w) {
        this.offsets = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            offsets[i] = w[i] + (i > 0 ? offsets[i - 1] : 0);
        }
        rightBoundary = offsets[offsets.length - 1];
    }

    public int pickIndex() {
        double nextNumber = rightBoundary * Math.random();

        int left = 0;
        int right = offsets.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nextNumber > offsets[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}

package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] - middle - 1 < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left + k;
    }
}

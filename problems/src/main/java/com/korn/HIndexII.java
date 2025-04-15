package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/h-index-ii/">H-Index II</a>
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (citations.length - middle == citations[middle]) {
                return citations[middle];
            } else if (citations[middle] < citations.length - middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return citations.length - left;
    }
}

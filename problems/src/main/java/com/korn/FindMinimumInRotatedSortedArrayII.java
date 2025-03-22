package com.korn;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">Find Minimum in Rotated Sorted Array II</a>
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int middle = left + (right - left) / 2;
            if (nums[right] > nums[middle]) {
                right = middle;
            } else if (nums[right] < nums[middle]) {
                left = middle + 1;
            } else {
                right = right - 1;
            }
        }

        return nums[left];
    }
}

package com.korn;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findIndex(nums, target, true);

        if (leftIndex == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{leftIndex, findIndex(nums, target, false)};
    }

    private int findIndex(int[] nums, int target, boolean searchFirst) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                if (searchFirst) {
                    if (middle == left || nums[middle - 1] != target) {
                        return middle;
                    }
                    right = middle - 1;
                } else {
                    if (middle == right || nums[middle + 1] != target) {
                        return middle;
                    }
                    left = middle + 1;
                }
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}

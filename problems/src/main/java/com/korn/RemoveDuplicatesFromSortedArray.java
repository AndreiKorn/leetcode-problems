package com.korn;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != previous) {
                nums[k] = nums[i];
                k++;
            }
            previous = current;
        }

        return k;
    }
}

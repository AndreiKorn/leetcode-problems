package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int toInsertIndex = 0;
        int toBeInsertedIndex = 0;
        while (toBeInsertedIndex < nums.length) {
            int current = nums[toBeInsertedIndex];
            if (current != 0) {
                nums[toInsertIndex++] = current;
            }
            toBeInsertedIndex++;
        }

        while (toInsertIndex < nums.length) {
            nums[toInsertIndex++] = 0;
        }
    }
}

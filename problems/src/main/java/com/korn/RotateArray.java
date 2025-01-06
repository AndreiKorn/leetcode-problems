package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */
public class RotateArray {
    public void rotateReversing(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public void rotateWithCycle(int[] nums, int k) {
        int length = nums.length;
        if (k % length == 0) {
            return;
        }
        k = k % length;
        int count = 0;
        for (int i = 0; count < length; i++) {
            int current = i;
            int currentValue = nums[current];
            do {
                int nextIndex = (current + k) % length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = currentValue;
                currentValue = nextValue;
                count++;
                current = nextIndex;
            } while (current != i);
        }
    }

    public void rotateWithAdditionalMemory(int[] nums, int k) {
        if (k % nums.length == 0) {
            return;
        }
        k = k % nums.length;

        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, length);
    }
}

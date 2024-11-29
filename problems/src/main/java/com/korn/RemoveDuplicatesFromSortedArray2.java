package com.korn;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int beforePrevious = nums[0];
        int previous = nums[1];
        int nextInsertPosition = 2;
        for (int i = 2; i < nums.length; i++) {
            int current = nums[i];
            if (current == previous && current == beforePrevious) {
                continue;
            }

            nums[nextInsertPosition] = current;
            beforePrevious = previous;
            previous = current;
            nextInsertPosition++;
        }

        return nextInsertPosition;
    }
}

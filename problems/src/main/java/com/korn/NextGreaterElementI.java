package com.korn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/next-greater-element-i/">Next Greater Element I</a>
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }

        Map<Integer, Integer> nextGreaterElements = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            while (!stack.isEmpty() && current >= stack.peekFirst()) {
                stack.pollFirst();
            }

            nextGreaterElements.put(current, stack.isEmpty() ? -1 : stack.peekFirst());
            stack.offerFirst(current);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterElements.get(nums1[i]);
        }

        return nums1;
    }
}

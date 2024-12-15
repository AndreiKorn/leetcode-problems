package com.korn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">Remove All Adjacent Duplicates In String</a>
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicatesWithStack(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Objects.equals(stack.peekLast(), current)) {
                stack.pollLast();
            } else {
                stack.offerLast(current);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }

        return result.toString();
    }

    public String removeDuplicatesWithStringBuilder(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!result.isEmpty() && result.charAt(result.length() - 1) == current) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(current);
            }
        }

        return result.toString();
    }

    public String removeDuplicatesWithTwoPointers(String s) {
        int firstPointer = 0;
        int secondPointer = 1;
        char[] result = s.toCharArray();
        while (secondPointer < result.length) {
            if (firstPointer >= 0 && result[firstPointer] == result[secondPointer]) {
                firstPointer--;
            } else {
                firstPointer++;
                result[firstPointer] = result[secondPointer];
            }
            secondPointer++;
        }

        return new String(result, 0, firstPointer + 1);
    }
}

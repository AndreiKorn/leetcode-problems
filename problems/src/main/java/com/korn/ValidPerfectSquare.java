package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-perfect-square/">Valid Perfect Square</a>
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num / 2;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            }

            if (num / middle < middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left * left == num;
    }
}

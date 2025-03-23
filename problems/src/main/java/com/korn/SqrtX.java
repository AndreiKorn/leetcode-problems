package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }

        int min = 2;
        int max = x / 2;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            long square = (long) middle * middle;
            if (square > x) {
                max = middle - 1;
            } else if (square < x) {
                min = middle + 1;
            } else {
                return middle;
            }
        }

        return max;
    }
}

package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">Guess Number Higher or Lower</a>
 */
public class GuessNumberHigherOrLower {
    private final int pick;

    public GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int middle = left + (right - left) / 2;
            int result = guess(middle);
            if (result == 0) {
                return middle;
            } else if (result < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private int guess(int num) {
        if (num == pick) {
            return 0;
        }

        return num > pick ? -1 : 1;
    }
}

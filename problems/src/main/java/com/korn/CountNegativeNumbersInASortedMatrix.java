package com.korn;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/">Count Negative Numbers in a Sorted Matrix</a>
 */
public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int lines = grid.length;
        int leftBoundary = grid[0].length;
        for (int i = 0; i < lines; i++) {
            int newBoundary = findLeftBoundary(grid[i], leftBoundary);
            if (newBoundary < leftBoundary) {
                count += (leftBoundary - newBoundary) * (lines - i);
                leftBoundary = newBoundary;
            }
        }
        return count;
    }

    private int findLeftBoundary(int[] gridLine, int leftBoundary) {
        while (leftBoundary > 0 && gridLine[leftBoundary - 1] < 0) {
            leftBoundary--;
        }
        return leftBoundary;
    }
}

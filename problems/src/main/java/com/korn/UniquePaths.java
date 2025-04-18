package com.korn;

import java.util.Arrays;

/**
 * Solution for <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 */
public class UniquePaths {
    public long uniquePaths(int m, int n) {
        long[][] grid = new long[m][n];
        for (long[] line : grid) {
            Arrays.fill(line, 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}

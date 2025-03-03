package com.korn;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/">Get Biggest Three Rhombus Sums in a Grid</a>
 */
public class GetBiggestThreeRhombusSumsInAGrid {
    public int[] getBiggestThree(int[][] grid) {
        SortedSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                updateSet(set, grid[i][j]);
                int size = 1;
                while (isRhombus(grid, i, j, size)) {
                    updateSet(set, calcSum(grid, i, j, size));
                    size++;
                }
            }
        }
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.removeFirst();
        }
        return result;
    }

    private void updateSet(SortedSet<Integer> set, int newValue) {
        set.add(newValue);
        while (set.size() > 3) {
            set.removeLast();
        }
    }

    private int calcSum(int[][] grid, int x, int y, int size) {
        int[] top = new int[]{x - size, y};
        int[] right = new int[]{x, y + size};
        int[] down = new int[]{x + size, y};
        int[] left = new int[]{x, y - size};
        x = top[0];
        y = top[1];
        int sum = 0;
        while (x < right[0] && y < right[1]) {
            sum += grid[x][y];
            x++;
            y++;
        }
        while (x < down[0] && y > down[1]) {
            sum += grid[x][y];
            x++;
            y--;
        }
        while (x > left[0] && y > left[1]) {
            sum += grid[x][y];
            x--;
            y--;
        }
        while (x > top[0] && y < top[1]) {
            sum += grid[x][y];
            x--;
            y++;
        }
        return sum;
    }

    private boolean isRhombus(int[][] grid, int x, int y, int size) {
        return x - size >= 0 && y - size >= 0 && x + size < grid.length && y + size < grid[0].length;
    }
}

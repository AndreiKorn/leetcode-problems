package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/dungeon-game/">Dungeon Game</a>
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        return helper(dungeon, new int[dungeon.length][dungeon[0].length], 0, 0);
    }

    private int helper(int[][] dungeon, int[][] memo, int i, int j) {
        if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
            return Math.abs(Math.min(0, dungeon[i][j])) + 1;
        } else if (i >= dungeon.length || j >= dungeon[i].length) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int rightResult = helper(dungeon, memo, i, j + 1);
        int bottomResult = helper(dungeon, memo, i + 1, j);

        int expectedHp = Math.min(rightResult, bottomResult);
        int currentDiff = dungeon[i][j];
        int currentHp = currentDiff < expectedHp ? expectedHp - currentDiff : 1;

        return memo[i][j] = currentHp;
    }
}

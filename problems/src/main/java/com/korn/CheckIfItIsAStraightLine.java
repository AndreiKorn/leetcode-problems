package com.korn;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">Check If It Is a Straight Line</a>
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int xDiffReference = coordinates[1][0] - coordinates[0][0];
        int yDiffReference = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int xDiff = coordinates[i][0] - coordinates[0][0];
            int yDiff = coordinates[i][1] - coordinates[0][1];
            if (xDiffReference * yDiff != xDiff * yDiffReference) {
                return false;
            }
        }
        return true;
    }
}

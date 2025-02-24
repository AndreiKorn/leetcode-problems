package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = findRow(matrix, target);
        return findTarget(matrix, rowNum, target);
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (matrix[middle][0] <= target && middle + 1 < matrix.length && matrix[middle + 1][0] > target) {
                return middle;
            } else if (matrix[middle][0] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return matrix[left][0] <= target ? left : -1;
    }

    private boolean findTarget(int[][] matrix, int rowNum, int target) {
        if (rowNum == -1) {
            return false;
        }

        int[] row = matrix[rowNum];
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (row[middle] == target) {
                return true;
            } else if (row[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return row[left] == target;
    }
}

package com.korn;

public class LongestIncreasingPathInAMatrix {
    private static final int[][] MOVES = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] pathLengths = new int[matrix.length][matrix[0].length];

        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, longestIncreasingPath(matrix, pathLengths, i, j));
            }
        }

        return result;
    }

    private int longestIncreasingPath(int[][] matrix, int[][] pathLengths, int row, int col) {
        if (pathLengths[row][col] != 0) {
            return pathLengths[row][col];
        }
        
        int longestPath = 0;
        for (int[] move : MOVES) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (neighbourIsLess(matrix, row, col, nextRow, nextCol)) {
                longestPath = Math.max(longestPath, longestIncreasingPath(matrix, pathLengths, nextRow, nextCol));
            }
        }
        pathLengths[row][col] = ++longestPath;
        return longestPath;
    }

    private boolean neighbourIsLess(
            int[][] matrix,
            int currentRow,
            int currentCol,
            int neighbourRow,
            int neighbourCol
    ) {
        return neighbourRow >= 0
                && neighbourCol >= 0
                && neighbourRow < matrix.length
                && neighbourCol < matrix[0].length
                && matrix[neighbourRow][neighbourCol] < matrix[currentRow][currentCol];
    }
}

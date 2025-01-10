package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rowsMasks = new int[9];
        int[] columnMasks = new int[9];
        int[] subBoxesMasks = new int[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int cellMask = 1 << (board[i][j] - '1');
                if ((rowsMasks[i] & cellMask) != 0) {
                    return false;
                }
                rowsMasks[i] |= cellMask;

                if ((columnMasks[j] & cellMask) != 0) {
                    return false;
                }
                columnMasks[j] |= cellMask;

                int subBoxIndex = (i / 3) * 3 + (j / 3);
                if ((subBoxesMasks[subBoxIndex] & cellMask) != 0) {
                    return false;
                }
                subBoxesMasks[subBoxIndex] |= cellMask;
            }
        }

        return true;
    }
}

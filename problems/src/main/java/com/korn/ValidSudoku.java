package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subBoxes = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (rows[i][board[i][j] - '1']) {
                    return false;
                } else {
                    rows[i][board[i][j] - '1'] = true;
                }

                if (columns[j][board[i][j] - '1']) {
                    return false;
                } else {
                    columns[j][board[i][j] - '1'] = true;
                }

                int subBoxIndex = (i / 3) * 3 + (j / 3);
                if (subBoxes[subBoxIndex][board[i][j] - '1']) {
                    return false;
                } else {
                    subBoxes[subBoxIndex][board[i][j] - '1'] = true;
                }
            }
        }

        return true;
    }
}

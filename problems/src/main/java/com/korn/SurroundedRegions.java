package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/surrounded-regions/">Surrounded Regions</a>
 */
public class SurroundedRegions {
    private static final int[][] MOVES = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                paint(board, i, 0);
            }

            if (board[i][board[i].length - 1] == 'O') {
                paint(board, i, board[i].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                paint(board, 0, i);
            }

            if (board[board.length - 1][i] == 'O') {
                paint(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void paint(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'Y';
        for (int[] move : MOVES) {
            paint(board, i + move[0], j + move[1]);
        }
    }
}

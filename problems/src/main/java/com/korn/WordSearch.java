package com.korn;

public class WordSearch {
    private static final int[][] MOVES = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        } else if (!validCoordinate(board, i, j) || word.charAt(index) != board[i][j]) {
            return false;
        }

        board[i][j] = '.';
        for (int[] move : MOVES) {
            if (exist(board, word, index + 1, i + move[0], j + move[1])) {
                return true;
            }
        }
        board[i][j] = word.charAt(index);
        return false;
    }

    private boolean validCoordinate(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}

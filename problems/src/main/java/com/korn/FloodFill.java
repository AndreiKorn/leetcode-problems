package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a>
 */
public class FloodFill {
    private static final int[][] MOVES = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            floodFill(image, sr, sc, image[sr][sc], color);
        }

        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int initialColor, int newColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == initialColor) {
            image[sr][sc] = newColor;
            for (int[] move : MOVES) {
                floodFill(image, sr + move[0], sc + move[1], initialColor, newColor);
            }
        }
    }
}

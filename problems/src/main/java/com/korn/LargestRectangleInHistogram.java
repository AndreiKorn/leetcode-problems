package com.korn;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] leftBoundaries = new int[length];
        leftBoundaries[0] = -1;
        for (int i = 1; i < length; i++) {
            int currentBoundary = i - 1;
            while (currentBoundary >= 0 && heights[currentBoundary] >= heights[i]) {
                currentBoundary = leftBoundaries[currentBoundary];
            }
            leftBoundaries[i] = currentBoundary;
        }

        int[] rightBoundaries = new int[length];
        rightBoundaries[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int currentBoundary = i + 1;
            while (currentBoundary < length && heights[currentBoundary] >= heights[i]) {
                currentBoundary = rightBoundaries[currentBoundary];
            }
            rightBoundaries[i] = currentBoundary;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentMax = heights[i] * (rightBoundaries[i] - leftBoundaries[i] - 1);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}

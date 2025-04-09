package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        List<Integer> result = List.of(1, 1);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> tempResult = new ArrayList<>(rowIndex + 1);
            tempResult.add(1);
            for (int j = 1; j < result.size(); j++) {
                tempResult.add(result.get(j - 1) + result.get(j));
            }
            tempResult.add(1);
            result = tempResult;
        }
        return result;
    }
}

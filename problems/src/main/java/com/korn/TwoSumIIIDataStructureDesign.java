package com.korn;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/two-sum-iii-data-structure-design/">Two Sum III - Data structure design</a>
 */
public class TwoSumIIIDataStructureDesign {
    private final Map<Integer, Integer> numbers = new HashMap<>();

    public void add(int number) {
        numbers.put(number, numbers.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer number : numbers.keySet()) {
            int diff = value - number;
            if (numbers.containsKey(value - number) && (diff != number || numbers.get(number) > 1)) {
                return true;
            }
        }
        return false;
    }
}

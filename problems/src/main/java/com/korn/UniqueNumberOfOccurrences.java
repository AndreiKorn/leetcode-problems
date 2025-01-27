package com.korn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution for <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Unique Number of Occurrences</a>
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrencesByNum = new HashMap<>();
        for (int num : arr) {
            occurrencesByNum.put(num, occurrencesByNum.getOrDefault(num, 0) + 1);
        }
        Set<Integer> occurrences = new HashSet<>(occurrencesByNum.values());

        return occurrencesByNum.size() == occurrences.size();
    }
}

package com.korn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/odd-string-difference">Odd String Difference</a>
 */
public class OddStringDifference {
    public String oddString(String[] words) {
        Map<String, List<Integer>> occurrences = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String diff = calcDiff(words[i]);
            List<Integer> indexes = occurrences.getOrDefault(diff, new ArrayList<>());
            indexes.add(i);
            occurrences.put(diff, indexes);
        }

        return occurrences.values()
                .stream()
                .filter(list -> list.size() == 1)
                .map(list -> words[list.get(0)])
                .findFirst()
                .orElse(null);
    }

    private String calcDiff(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            result.append(word.charAt(i) - word.charAt(i - 1)).append(".");
        }
        return result.toString();
    }
}

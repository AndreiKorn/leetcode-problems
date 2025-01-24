package com.korn;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution for <a href="https://leetcode.com/problems/most-common-word/">Most Common Word</a>
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        Collections.addAll(bannedSet, banned);

        Map<String, Integer> frequencies = new HashMap<>();
        String mostFrequentKey = "";
        for (String word : paragraph.split("[ !?',;.]")) {
            word = word.toLowerCase();
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
                if (frequencies.get(word) > frequencies.getOrDefault(mostFrequentKey, 0)) {
                    mostFrequentKey = word;
                }
            }
        }

        return mostFrequentKey;
    }
}

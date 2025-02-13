package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }

        int[] occurrencesOfP = new int[26];
        int[] occurrencesOfS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            occurrencesOfP[p.charAt(i) - 'a']++;
            occurrencesOfS[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        if (equals(occurrencesOfP, occurrencesOfS)) {
            result.add(0);
        }
        int diff = p.length();
        for (int i = diff; i < s.length(); i++) {
            occurrencesOfS[s.charAt(i - diff) - 'a']--;
            occurrencesOfS[s.charAt(i) - 'a']++;
            if (equals(occurrencesOfP, occurrencesOfS)) {
                result.add(i - diff + 1);
            }
        }

        return result;
    }

    private static boolean equals(int[] first, int[] second) {
        if (first.length == second.length) {
            for (int i = 0; i < first.length; i++) {
                if (first[i] != second[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}

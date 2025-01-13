package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/ransom-note/">Ransom Note</a>
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charsFrequency = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charsFrequency[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (charsFrequency[index] > 0) {
                charsFrequency[index]--;
            } else {
                return false;
            }
        }

        return true;
    }
}

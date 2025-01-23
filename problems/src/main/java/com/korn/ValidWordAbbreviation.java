package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-word-abbreviation/">Valid Word Abbreviation</a>
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0;
        int abbrPointer = 0;
        while (wordPointer < word.length() && abbrPointer < abbr.length()) {
            if (isLetter(abbr.charAt(abbrPointer))) {
                if (abbr.charAt(abbrPointer) != word.charAt(wordPointer)) {
                    return false;
                }
                abbrPointer++;
                wordPointer++;
            } else {
                int lettersSkipped = abbr.charAt(abbrPointer) - '0';
                if (lettersSkipped == 0) {
                    return false;
                }
                abbrPointer++;

                while (abbrPointer < abbr.length() && isNumber(abbr.charAt(abbrPointer))) {
                    lettersSkipped = lettersSkipped * 10 + (abbr.charAt(abbrPointer) - '0');
                    abbrPointer++;
                }
                wordPointer += lettersSkipped;
            }
        }

        return wordPointer == word.length() && abbrPointer == abbr.length();
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}

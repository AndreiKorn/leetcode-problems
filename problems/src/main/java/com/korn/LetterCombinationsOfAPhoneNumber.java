package com.korn;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">Letter Combinations of a Phone Number</a>
 */
public class LetterCombinationsOfAPhoneNumber {
    private static final char[][] CHARS_BY_DIGITS = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }

        List<String> result = new LinkedList<>();
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder tempResult, String digits, int position) {
        if (position == digits.length()) {
            result.add(tempResult.toString());
            return;
        }

        char digitIndex = digits.charAt(position);
        for (char c : CHARS_BY_DIGITS[digitIndex - '2']) {
            tempResult.append(c);
            backtrack(result, tempResult, digits, position + 1);
            tempResult.setLength(position);
        }
    }
}

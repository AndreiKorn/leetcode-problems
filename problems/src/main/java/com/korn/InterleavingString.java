package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/interleaving-string/">Interleaving String</a>
 */
public class InterleavingString {
    private Boolean[][] results;

    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        results = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleave(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index) {
        if (results[s1Index][s2Index] != null) {
            return results[s1Index][s2Index];
        }

        if (s3Index == s3.length()) {
            results[s1Index][s2Index] = s1Index == s1.length() && s2Index == s2.length();
            return results[s1Index][s2Index];
        }

        boolean result = fits(s1, s1Index, s3, s3Index) && isInterleave(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1)
                || fits(s2, s2Index, s3, s3Index) && isInterleave(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1);

        return results[s1Index][s2Index] = result;
    }

    private boolean fits(String s, int sIndex, String expected, int expectedIndex) {
        return sIndex < s.length() && s.charAt(sIndex) == expected.charAt(expectedIndex);
    }

    public boolean isInterleave2Dp(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] results = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    results[i][j] = true;
                } else if (i == 0) {
                    results[i][j] = results[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    results[i][j] = results[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    results[i][j] = results[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                            || results[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
            }
        }

        return results[s1.length()][s2.length()];
    }
}

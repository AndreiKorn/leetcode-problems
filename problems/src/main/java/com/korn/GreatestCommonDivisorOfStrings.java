package com.korn;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">Greatest Common Divisor of Strings</a>
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int smaller, int bigger) {
        int divisor = smaller;
        while (bigger % divisor != 0) {
            divisor = bigger % divisor;
            bigger = smaller;
            smaller = divisor;
        }
        return divisor;
    }
}

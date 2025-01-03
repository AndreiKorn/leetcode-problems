package com.korn;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(result, s, new Integer[4], 0, 0);

        return result;
    }

    private void backtrack(
            List<String> result,
            String original,
            Integer[] ipParts,
            int partIndex,
            int position
    ) {
        if (partIndex > 3) {
            if (position >= original.length()) {
                StringBuilder sb = new StringBuilder();
                for (int part : ipParts) {
                    sb.append(part).append(".");
                }
                sb.deleteCharAt(sb.length() - 1);

                result.add(sb.toString());
            }

            return;
        }

        int currentNum = 0;
        for (int i = 0; i < 3 && (position + i) < original.length(); i++) {
            if (i > 0 && currentNum == 0) {
                return;
            }
            currentNum = currentNum * 10 + (original.charAt(position + i) - '0');

            if (currentNum <= 255) {
                ipParts[partIndex] = currentNum;
                backtrack(result, original, ipParts, partIndex + 1, position + i + 1);
            } else {
                return;
            }
        }
    }
}

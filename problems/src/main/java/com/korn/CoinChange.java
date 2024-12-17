package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] changes) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        } else if (changes[amount - 1] != 0) {
            return changes[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = coins.length -1; i >= 0; i--) {
            int coin = coins[i];
            int remainderChange = coinChange(coins, amount - coin, changes);
            if (remainderChange >= 0) {
                min = Math.min(min, remainderChange + 1);
            }
        }

        changes[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;

        return changes[amount - 1];
    }
}

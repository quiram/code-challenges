package com.github.quiram.challenges.medium.coinchange;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
 */
class Solution {
    private int[][] cache;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        cache = new int[coins.length][amount + 1];
        for (int[] arrays : cache) Arrays.fill(arrays, -2);

        this.coins = coins;

        return solve(0, amount);
    }

    private int solve(int i, int amount) {
        if (amount == 0)
            return 0;

        if (i >= cache.length)
            return -1;

        if (cache[i][amount] > -2)
            return cache[i][amount];

        int result = Integer.MAX_VALUE;
        boolean resultAvailable = false;
        for (int coinCount = 0; coinCount <= amount / coins[i]; coinCount++) {
            int partialResult = solve(i + 1, amount - coinCount * coins[i]);
            if (partialResult > -1) {
                partialResult += coinCount;
                if (partialResult < result) {
                    result = partialResult;
                    resultAvailable = true;
                }
            }
        }

        cache[i][amount] = resultAvailable ? result : -1;
        return cache[i][amount];
    }
}

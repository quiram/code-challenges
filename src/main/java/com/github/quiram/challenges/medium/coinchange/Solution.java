package com.github.quiram.challenges.medium.coinchange;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
 */
class Solution {
    private int[] cache;

    public int coinChange(int[] coins, int amount) {
        cache = new int[amount + 1];
        Arrays.fill(cache, -2);

        return solve(coins, amount);
    }

    private int solve(int[] coins, int amount) {
        if (amount < 0)
            return -1;

        if (amount == 0)
            return 0;

        if (cache[amount] > -2)
            return cache[amount];

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int partialResult = solve(coins, amount - coin);
            if (partialResult > -1) {
                partialResult++;
                if (partialResult < result) {
                    result = partialResult;
                }
            }
        }

        cache[amount] = result < Integer.MAX_VALUE ? result : -1;
        return cache[amount];
    }
}

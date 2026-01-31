package com.github.quiram.challenges.medium.coinchange;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);
        amounts[0] = 0;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i)
                    amounts[i] = Math.min(amounts[i], 1 + amounts[i - coin]);
            }
        }

        return amounts[amount] > amount ? -1 : amounts[amount];
    }
}

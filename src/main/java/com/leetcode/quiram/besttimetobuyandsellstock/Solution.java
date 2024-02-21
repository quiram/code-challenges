package com.leetcode.quiram.besttimetobuyandsellstock;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int newProfit = prices[j] - prices[i];
                if (newProfit > profit) {
                    profit = newProfit;
                }
            }
        }

        return profit;
    }
}
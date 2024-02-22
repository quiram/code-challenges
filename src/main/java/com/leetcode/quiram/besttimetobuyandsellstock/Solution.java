package com.leetcode.quiram.besttimetobuyandsellstock;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }

            if (price - min > profit) {
                profit = price - min;
            }
        }

        return profit;
    }

}
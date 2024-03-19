package com.leetcode.quiram.medium.maximumsubarray;

import static java.lang.Integer.MIN_VALUE;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">53. Maximum Subarray</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int max = MIN_VALUE;
        int acc = 0;

        for (int n : nums) {
            int accPlusN = acc + n;
            acc = Integer.max(n, accPlusN);
            max = Integer.max(max, acc);
        }

        return max;
    }
}
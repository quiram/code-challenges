package com.leetcode.quiram.medium.maximumsubarray;

import static java.lang.Integer.MIN_VALUE;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">53. Maximum Subarray</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int max = MIN_VALUE;
        int acc = MIN_VALUE;

        for (int n : nums) {
            int accPlusN = acc == MIN_VALUE && n < 0 ? MIN_VALUE : acc + n;
            if (acc > n && acc > accPlusN) {
                if (acc > max) {
                    max = acc;
                }
                acc = accPlusN;
            } else if (n >= acc && n >= accPlusN) {
                acc = n;
            } else {
                acc = accPlusN;
            }
        }

        if (acc > max) {
            max = acc;
        }

        return max;
    }
}
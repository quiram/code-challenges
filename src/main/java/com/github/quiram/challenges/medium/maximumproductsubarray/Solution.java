package com.github.quiram.challenges.medium.maximumproductsubarray;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;
import static java.lang.Math.abs;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">152. Maximum Product Subarray</a>
 */
class Solution {
    public int maxProduct(int[] nums) {
        int[] reverse_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reverse_nums[nums.length - 1 - i] = nums[i];
        }

        return max(maxForward(nums), maxForward(reverse_nums));
    }

    private int maxForward(int[] nums) {
        int abs_prod = 1;
        int prod = 1;
        int max = MIN_VALUE;
        for (int n : nums) {
            abs_prod = abs(abs_prod * n) > abs(n) ? abs_prod * n : n;
            prod = max(prod * n, max(n, abs_prod));
            max = max(max, prod);
        }
        return max;
    }
}
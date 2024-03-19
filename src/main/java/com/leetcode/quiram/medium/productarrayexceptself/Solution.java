package com.leetcode.quiram.medium.productarrayexceptself;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">238. Product of Array Except Self</a>
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] prefixes = new int[n];
        final int[] suffixes = new int[n];
        final int[] answers = new int[n];

        prefixes[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i - 1];
        }

        suffixes[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixes[i] = suffixes[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answers[i] = prefixes[i] * suffixes[i];
        }

        return answers;
    }
}

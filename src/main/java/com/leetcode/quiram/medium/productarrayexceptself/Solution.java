package com.leetcode.quiram.medium.productarrayexceptself;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">238. Product of Array Except Self</a>
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] answers = new int[n];

        // answers accumulates prefixes
        answers[0] = 1;
        for (int i = 1; i < n; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }

        // nums turn into suffixes
        int acc = nums[n - 1];
        nums[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            final int newValue = nums[i] * acc;
            nums[i] = acc;
            acc = newValue;
        }

        // aggregate prefixes and suffixes
        for (int i = 0; i < n; i++) {
            answers[i] = answers[i] * nums[i];
        }

        return answers;
    }
}

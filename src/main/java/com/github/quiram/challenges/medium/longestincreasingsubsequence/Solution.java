package com.github.quiram.challenges.medium.longestincreasingsubsequence;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 */
class Solution {
    int[] results;

    public int lengthOfLIS(int[] nums) {
        results = new int[nums.length];

        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = 1 + solve(nums, nums[i], i + 1);
            if (results[i] > result) {
                result = results[i];
            }

        }

        return result;
    }

    private int solve(int[] a, int n, int i) {
        int result = 0;

        for (int j = i; j < a.length; j++) {
            if (n < a[j] && results[j] > result) {
                result = results[j];
            }
        }

        return result;
    }
}


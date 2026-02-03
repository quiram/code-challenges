package com.github.quiram.challenges.medium.longestincreasingsubsequence;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 */
class Solution {
    int[][] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[20002][nums.length];
        for (int[] array : memo) {
            Arrays.fill(array, -1);
        }
        return solve(nums, -10001, 0);
    }

    private int solve(int[] a, int max, int i) {
        if (i == a.length)
            return 0;

        int cache_index = max < 0 ? 10000 - max : max;
        int cached = memo[cache_index][i];
        if (cached > -1)
            return cached;

        int n = a[i];

        final int solution_without_n = solve(a, max, i + 1);
        if (n <= max)
            return solution_without_n;

        final int solution_with_n = solve(a, n, i + 1);

        final int result = Math.max(1 + solution_with_n, solution_without_n);
        memo[cache_index][i] = result;
        return result;
    }
}


package com.github.quiram.challenges.medium.longestcommonsubsequence;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/">1143. Longest Common Subsequence</a>
 */
class Solution {
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] array : memo)
            Arrays.fill(array, -1);

        return solve(text1, text2, text1.length(), text2.length());
    }

    private int solve(String text1, String text2, int i1, int i2) {
        if (i1 == 0 || i2 == 0)
            return 0;

        if (memo[i1 - 1][i2 - 1] > -1)
            return memo[i1 - 1][i2 - 1];

        final int result;
        if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1))
            result = 1 + solve(text1, text2, i1 - 1, i2 - 1);
        else
            result = Math.max(solve(text1, text2, i1 - 1, i2), solve(text1, text2, i1, i2 - 1));

        memo[i1 - 1][i2 - 1] = result;
        return result;
    }
}

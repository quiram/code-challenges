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

        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int i1, int i2) {
        if (i1 == text1.length() || i2 == text2.length())
            return 0;

        if (memo[i1][i2] > -1)
            return memo[i1][i2];

        char c = text1.charAt(i1);
        int new_i2 = text2.indexOf(c, i2);

        final int solution_without_c = solve(text1, text2, i1 + 1, i2);
        int result;
        if (new_i2 == -1)
            result = solution_without_c;
        else {
            final int solution_with_c = solve(text1, text2, i1 + 1, new_i2 + 1);
            result = Math.max(solution_without_c, 1 + solution_with_c);
        }

        memo[i1][i2] = result;
        return result;
    }
}
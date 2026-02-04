package com.github.quiram.challenges.medium.longestcommonsubsequence;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/">1143. Longest Common Subsequence</a>
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] results = new int[t1.length + 1][t2.length + 1];

        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1])
                    results[i][j] = 1 + results[i - 1][j - 1];
                else
                    results[i][j] = Math.max(results[i - 1][j], results[i][j - 1]);
            }
        }

        return results[t1.length][t2.length];
    }
}

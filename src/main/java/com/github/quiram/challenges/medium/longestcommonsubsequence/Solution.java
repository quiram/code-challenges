package com.github.quiram.challenges.medium.longestcommonsubsequence;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/">1143. Longest Common Subsequence</a>
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] results = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    results[i][j] = 1 + results[i - 1][j - 1];
                else
                    results[i][j] = Math.max(results[i - 1][j], results[i][j - 1]);
            }
        }

        return results[text1.length()][text2.length()];
    }
}

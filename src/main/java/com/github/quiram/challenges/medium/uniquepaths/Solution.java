package com.github.quiram.challenges.medium.uniquepaths;

/**
 * <a href="https://leetcode.com/problems/unique-paths/description/">62. Unique Paths</a>
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] results = new int[m][n];
        results[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j < n - 1)
                    results[i][j] += results[i][j + 1];

                if (i < m - 1)
                    results[i][j] += results[i + 1][j];
            }
        }

        return results[0][0];
    }
}

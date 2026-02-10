package com.github.quiram.challenges.medium.uniquepaths;

/**
 * <a href="https://leetcode.com/problems/unique-paths/description/">62. Unique Paths</a>
 */
class Solution {
    /**
     * This is a combinatorial problem:
     * ( m + n )
     * result = (       ) = (m+n)! / (m! n!)
     * (   n   )
     * <p>
     * Assuming m >= n, then
     * <p>
     * result = (m+n)(m+n-1)(m+n-2)...(m+1)/n!
     */
    public int uniquePaths(int m, int n) {
        // m and n indicate the size of the grid, we need to take m-1 and n-1 steps
        m--;
        n--;

        // Invert input to ensure m >=n
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        long result = 1;

        for (int i = 0; i < n; i++) {
            result *= m + n - i;
            result /= (i + 1);
        }

        return (int) result;
    }
}

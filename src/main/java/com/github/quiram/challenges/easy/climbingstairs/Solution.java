package com.github.quiram.challenges.easy.climbingstairs;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        for (int i = 0; i <= n; i++)
            cache[i] = -1;
        return solve(n);
    }

    private int solve(int n) {
        if (cache[n] != -1)
            return cache[n];

        final int result;
        if (n == 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else if (n == 2)
            result = 2;
        else
            result = solve(n - 1) + solve(n - 2);

        cache[n] = result;
        return result;
    }


}
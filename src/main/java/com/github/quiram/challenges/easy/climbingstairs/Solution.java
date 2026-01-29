package com.github.quiram.challenges.easy.climbingstairs;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
class Solution {
    public int climbStairs(int n) {
        /*
        This is essentially a Fibonacci sequence, for which a formula exists.
        The formula is zero-indexed so we need to increase n to make it work.
         */
        n++;
        final double sqrt_5 = Math.sqrt(5);
        final double phi = (1 + sqrt_5) / 2;
        return (int) Math.round(Math.pow(phi, n) / sqrt_5);
    }
}
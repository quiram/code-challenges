package com.github.quiram.challenges.medium.combinationsum4;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/description/">377. Combination Sum IV</a>
 */
class Solution {
    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return solve(nums, target);
    }

    private int solve(int[] nums, int target) {
        if (target < 0)
            return 0;

        if (memo[target] > -1)
            return memo[target];

        int result = 0;
        for (int num : nums) {
            result += solve(nums, target - num);
        }

        memo[target] = result;
        return result;
    }
}

package com.github.quiram.challenges.medium.combinationsum4;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iv/description/">377. Combination Sum IV</a>
 */
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] results = new int[target + 1];
        results[0] = 1;

        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (num <= i)
                    results[i] += results[i - num];

        return results[target];
    }
}

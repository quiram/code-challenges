package com.github.quiram.challenges.medium.houserobber2.houserobber;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/description/">213. House Robber II</a>
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        final int[] rob_first = new int[nums.length];
        final int[] skip_first = new int[nums.length];
        rob_first[1] = nums[0];
        skip_first[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            rob_first[i] = Math.max(rob_first[i - 1], rob_first[i - 2] + nums[i - 1]);
            skip_first[i] = Math.max(skip_first[i - 1], skip_first[i - 2] + nums[i]);
        }
        return Math.max(rob_first[nums.length - 1], skip_first[nums.length - 1]);
    }
}

package com.github.quiram.challenges.medium.houserobber;

/**
 * <a href="https://leetcode.com/problems/house-robber/description/">198. House Robber</a>
 */
class Solution {
    public int rob(int[] nums) {
        final int[] haul = new int[nums.length + 1];
        haul[0] = 0;
        haul[1] = nums[0];

        for (int i = 2; i < haul.length; i++)
            haul[i] = Math.max(haul[i - 1], haul[i - 2] + nums[i - 1]);

        return haul[nums.length];
    }
}

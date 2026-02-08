package com.github.quiram.contests.leetcode488.q1;

/**
 * <a href="https://leetcode.com/contest/weekly-contest-488/problems/count-dominant-indices/">Q1. Count Dominant Indices</a>
 */
class Solution {
    public int dominantIndices(int[] nums) {
        int result = 0;
        double currentAverage = 0;
        for (int i = 1; i < nums.length; i++) {
            currentAverage = (currentAverage * (i - 1) + nums[nums.length - i]) / i;
            if (nums[nums.length - i - 1] > currentAverage)
                result++;
        }

        return result;
    }
}
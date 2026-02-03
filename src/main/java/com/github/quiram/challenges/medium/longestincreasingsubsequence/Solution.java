package com.github.quiram.challenges.medium.longestincreasingsubsequence;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 */
class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        sub[0] = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub[count]) {
                // Add to the bucket
                count++;
                sub[count] = num;
            } else {
                // Insert in the relevant position in the bucket
                // Relevant position is replacing the lowest number that is >= num
                int low = 0;
                int high = count;
                while (low < high) {
                    int pivot = (low + high) / 2;
                    if (sub[pivot] < num) {
                        low = pivot + 1;
                    } else {
                        high = pivot;
                    }
                }

                sub[low] = num;
            }
        }

        return count + 1;
    }

}


package com.leetcode.quiram.containsduplicate2;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/description/">219. Contains Duplicate II</a>
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
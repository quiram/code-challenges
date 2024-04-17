package com.github.quiram.challenges.easy.duplicatesfromsortedarray;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">26. Remove Duplicates from Sorted Array</a>
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicates++;
            } else {
                nums[i - duplicates] = nums[i];
            }
        }

        return nums.length - duplicates;
    }
}

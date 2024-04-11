package com.github.quiram.challenges.hard.nextpermutation;

/**
 * <a href="https://leetcode.com/problems/next-permutation/">31. Next Permutation</a>
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // find position that needs to increase
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        i--;

        // invert the rest
        for (int j = 1; j < (nums.length - i + 1) / 2; j++) {
            int temp = nums[i + j];
            nums[i + j] = nums[nums.length - j];
            nums[nums.length - j] = temp;
        }

        // find first digit higher than nums[i] and swap it
        // (only if we didn't invert the entire array)
        if (i >= 0) {
            int j = i;
            while (nums[j] <= nums[i]) {
                j++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
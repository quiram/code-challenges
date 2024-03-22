package com.leetcode.quiram.medium.findminimuminrotatedsortedarray;

import static java.lang.Math.min;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a>
 */
class Solution {
    public int findMin(int[] nums) {
        final int n = nums.length;
        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }

        int ini = 0;
        int end = n - 1;
        int pivot = (ini + end) / 2;

        while (pivot != ini && pivot != end) {
            if (nums[ini] < nums[pivot]) {
                ini = pivot;
            } else {
                end = pivot;
            }
            pivot = (ini + end) / 2;
        }

        return min(nums[ini], nums[end]);
    }
}
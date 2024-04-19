package com.github.quiram.challenges.hard.findandlastpositionofelementinsortedarray;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    private int search(int[] nums, int target, boolean lowerBound) {
        int ini = 0;
        int end = nums.length - 1;
        int index = -1;

        while (ini <= end) {
            int pivot = (ini + end) / 2;

            if (target < nums[pivot]) {
                end = pivot - (end == pivot ? 1 : 0);
            } else if (target > nums[pivot]) {
                ini = pivot + (ini == pivot ? 1 : 0);
            } else {
                index = pivot;
                if (lowerBound) {
                    end = pivot - 1;
                } else {
                    ini = pivot + 1;
                }
            }
        }

        return index;
    }
}


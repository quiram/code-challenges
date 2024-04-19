package com.github.quiram.challenges.hard.findandlastpositionofelementinsortedarray;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // double binary search, one looking for lower bound, another looking for upper bound
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    public int search(int[] nums, int target, boolean lowerBound) {
        int ini = 0;
        int end = nums.length - 1;

        while (true) {
            if (end - ini <= 1) {
                if (nums[ini] == target && (lowerBound || nums[end] != target)) {
                    return ini;
                }
                if (nums[end] == target) {
                    return end;
                }
                return -1;
            }

            int pivot = (ini + end) / 2;

            if (nums[pivot] > target || lowerBound && nums[pivot] == target) {
                end = pivot;
            } else {
                ini = pivot;
            }
        }
    }
}
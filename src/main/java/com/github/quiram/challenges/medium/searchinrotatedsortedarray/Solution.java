package com.github.quiram.challenges.medium.searchinrotatedsortedarray;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 */
class Solution {
    public int search(int[] nums, int target) {
        final int n = nums.length;
        int ini = 0;
        int end = n - 1;
        int pivot = (ini + end) / 2;

        while (pivot != ini && pivot != end) {
            // normal binary search
            if (nums[ini] < nums[end]) {
                if (target < nums[pivot]) {
                    end = pivot;
                } else {
                    ini = pivot;
                }
            } else {
                // rotated array
                if (target < nums[pivot]) {
                    if (nums[ini] < nums[pivot]) {
                        if (target >= nums[ini]) {
                            end = pivot;
                        } else {
                            ini = pivot;
                        }
                    } else {
                        end = pivot;
                    }
                } else {
                    if (nums[pivot] < nums[end]) {
                        if (target <= nums[end]) {
                            ini = pivot;
                        } else {
                            end = pivot;
                        }
                    } else {
                        ini = pivot;
                    }
                }
            }
            pivot = (ini + end) / 2;
        }

        if (nums[ini] == target) {
            return ini;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
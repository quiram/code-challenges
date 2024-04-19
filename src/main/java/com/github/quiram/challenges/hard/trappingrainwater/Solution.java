package com.github.quiram.challenges.hard.trappingrainwater;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 */
class Solution {
    public int trap(int[] height) {
        int total = 0;
        int i = 0;
        int potential = 0;

        for (int j = i + 1; j < height.length; j++) {
            if (height[j] < height[i]) {
                potential += height[i] - height[j];
            } else {
                total += potential;
                potential = 0;
                i = j;
            }
        }

        int peak = i;
        i = height.length - 1;
        potential = 0;

        for (int j = i - 1; j >= peak; j--) {
            if (height[j] < height[i]) {
                potential += height[i] - height[j];
            } else {
                total += potential;
                potential = 0;
                i = j;
            }
        }

        return total;
    }
}
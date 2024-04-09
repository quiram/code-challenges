package com.github.quiram.challenges.medium.conatinerwithmostwater;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>
 */
class Solution {
    public int maxArea(int[] height) {
        int currentMax = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        do {
            int newMax = (j - i) * Math.min(height[i], height[j]);
            if (newMax > currentMax) {
                currentMax = newMax;
            }

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        while (i < j);

        return currentMax;
    }

}
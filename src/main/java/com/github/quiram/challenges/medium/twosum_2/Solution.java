package com.github.quiram.challenges.medium.twosum_2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j > -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new RuntimeException("solution should be guaranteed");
    }
}
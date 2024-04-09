package com.github.quiram.challenges.medium.twosum_2;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ini = 0, end = numbers.length - 1;
        int sum;
        do {
            sum = numbers[ini] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                ini++;
            }
        }
        while (sum != target);

        return new int[]{ini + 1, end + 1};
    }
}
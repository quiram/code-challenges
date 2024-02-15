package com.leetcode.quiram.twosum;

import java.util.HashMap;
import java.util.Map;

/***
 * <a href="https://leetcode.com/problems/two-sum/">source</a>
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> indexLookUp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexLookUp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final Integer matchingIndex = indexLookUp.get(target - nums[i]);
            if (matchingIndex != null && i != matchingIndex) {
                return new int[]{i, matchingIndex};
            }
        }

        throw new RuntimeException();
    }
}
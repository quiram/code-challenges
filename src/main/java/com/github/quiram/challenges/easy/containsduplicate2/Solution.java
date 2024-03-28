package com.github.quiram.challenges.easy.containsduplicate2;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/description/">219. Contains Duplicate II</a>
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer j = m.get(nums[i]);
            if (j == null) {
                m.put(nums[i], i);
            } else {
                if (i - j <= k) {
                    return true;
                }
                m.put(nums[i], i);
            }
        }

        return false;
    }
}
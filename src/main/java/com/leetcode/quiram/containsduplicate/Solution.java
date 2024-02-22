package com.leetcode.quiram.containsduplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">217. Contains Duplicate</a>
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();

        int i;
        for (i = 0; i < nums.length && !set.contains(nums[i]); i++) {
            set.add(nums[i]);
        }

        return i != nums.length;
    }
}
package com.leetcode.quiram.containsduplicate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">217. Contains Duplicate</a>
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return set.size() != nums.length;
    }
}
package com.github.quiram.contests.weeklyleetcode488.q2;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/contest/weekly-contest-488/problems/merge-adjacent-equal-elements/">Q2. Merge Adjacent Equal Elements</a>
 */
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        final List<Long> result = new java.util.ArrayList<>(Arrays.stream(nums).mapToLong(i -> i).boxed().toList());

        int i = 0;
        while (i < result.size() - 1) {
            if (result.get(i).equals(result.get(i + 1))) {
                result.set(i, result.get(i) * 2);
                result.remove(i + 1);
                if (i > 0)
                    i--;
            } else {
                i++;
            }
        }

        return result;
    }
}
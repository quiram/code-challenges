package com.github.quiram.challenges.easy.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/description/">118. Pascal's Triangle</a>
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            final List<Integer> seed = result.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < seed.size(); j++) {
                newRow.add(seed.get(j) + seed.get(j - 1));
            }
            newRow.add(1);
            result.add(newRow);
        }

        return result;
    }
}
package com.github.quiram.challenges.medium.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">22. Generate Parenthesis</a>
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        return solve(new StringBuilder(), 0, n);
    }

    public List<String> solve(StringBuilder currentString, int open, int toOpen) {
        if (open == 0 && toOpen == 0)
            return List.of(currentString.toString());

        List<String> results = new ArrayList<>();

        if (open > 0) {
            results.addAll(solve(new StringBuilder(currentString).append(')'), open - 1, toOpen));
        }

        if (toOpen > 0) {
            results.addAll(solve(new StringBuilder(currentString).append('('), open + 1, toOpen - 1));
        }

        return results;
    }
}
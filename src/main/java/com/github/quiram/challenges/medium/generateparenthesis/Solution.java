package com.github.quiram.challenges.medium.generateparenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">22. Generate Parenthesis</a>
 * <p>
 * This is a Catalan sequence that can be defined as follows
 * f(0) = ""
 * f(n > 0) = Union( "(" + f(i) + ")" + f(n-i-1) ) for i = 0...n-1
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<StringBuilder>[] result = new List[n + 1];
        result[0] = List.of(new StringBuilder());

        for (int i = 1; i < result.length; i++) {
            result[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (StringBuilder sb1 : result[j])
                    for (StringBuilder sb2 : result[i - j - 1])
                        result[i].add(new StringBuilder().append('(').append(sb1).append(')').append(sb2));
            }
        }

        final List<String> results = new ArrayList<>();
        for (StringBuilder sb : result[n])
            results.add(sb.toString());

        return results;
    }
}

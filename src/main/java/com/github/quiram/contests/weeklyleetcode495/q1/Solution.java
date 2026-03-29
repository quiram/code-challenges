package com.github.quiram.contests.weeklyleetcode495.q1;

/**
 * <a href="https://leetcode.com/contest/weekly-contest-495/problems/first-matching-character-from-both-ends/">Q1. First Matching Character From Both Ends</a>
 */
class Solution {
    public int firstMatchingIndex(String s) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length / 2; i++) {
            if (chars[i] == chars[chars.length - i - 1])
                return i;
        }

        return -1;
    }
}
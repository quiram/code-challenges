package com.github.quiram.challenges.medium.workdbreak;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-break/description/">139. Word Break</a>
 */
class Solution {
    private Map<String, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return solve(s, 0, s.length(), new HashSet<>(wordDict));
    }

    private boolean solve(String s, int start, int end, Set<String> wordDict) {
        if (start >= end)
            return false;

        String word = s.substring(start, end);
        if (wordDict.contains(word))
            return true;

        Boolean result = memo.get(word);
        if (result != null)
            return result;

        result = false;
        for (int i = start + 1; i < end && !result; i++) {
            result = solve(s, start, i, wordDict) && solve(s, i, end, wordDict);
        }

        memo.put(word, result);
        return result;
    }
}
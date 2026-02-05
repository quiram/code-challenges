package com.github.quiram.challenges.medium.workdbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break/description/">139. Word Break</a>
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] segmentations = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        int maxWordLength = 0;

        for (String word : wordDict)
            maxWordLength = Math.max(maxWordLength, word.length());

        segmentations[0] = true;
        for (int i = 1; i < segmentations.length; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxWordLength) && !segmentations[i]; j--) {
                segmentations[i] = segmentations[j] && dict.contains(s.substring(j, i));
            }
        }

        return segmentations[segmentations.length - 1];
    }
}

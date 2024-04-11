package com.github.quiram.challenges.easy.aliendictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">953. Verifying an Alien Dictionary</a>
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indices.put(order.charAt(i), i);
        }


        for (int i = 0; i < words.length - 1; i++) {
            String thisWord = words[i];
            String nextWord = words[i + 1];

            int j = 0;
            boolean exit = false;
            while (!exit && j < thisWord.length() && j < nextWord.length()) {
                int thisIndex = indices.get(thisWord.charAt(j));
                int nextIndex = indices.get(nextWord.charAt(j));

                if (thisIndex > nextIndex) {
                    return false;
                } else if (thisIndex < nextIndex) {
                    exit = true;
                } else {
                    j++;
                }
            }

            if (j == nextWord.length() && thisWord.length() > nextWord.length()) {
                return false;
            }
        }

        return true;
    }
}
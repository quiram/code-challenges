package com.github.quiram.challenges.medium.decodeways;

/**
 * <a href="https://leetcode.com/problems/decode-ways/description/">91. Decode Ways</a>
 */
class Solution {
    public int numDecodings(String s) {
        final char[] msg = s.toCharArray();
        final int[] results = new int[msg.length];

        for (int i = 0; i < results.length; i++) {
            // 1. consider msg[i] in isolation
            if (msg[i] != '0') {
                results[i] += (i > 0) ? results[i - 1] : 1;
            }

            // 2. consider msg[i] as a second digit, where msg[i-1] may be the first
            if (i > 0 && (msg[i - 1] == '1' || msg[i - 1] == '2' && msg[i] <= '6')) {
                results[i] += (i > 1) ? results[i - 2] : 1;
            }
        }

        return results[results.length - 1];
    }

}
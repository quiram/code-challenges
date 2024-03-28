package com.github.quiram.challenges.hard.colorfulnumbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://tutorialhorizon.com/algorithms/colorful-numbers/">123. Colourful Numbers</a>
 */
class Solution {
    static boolean isColorfulNumber(int i) {
        final Set<Integer> set = new HashSet<>();
        final String s = Integer.toString(i);
        final int n = s.length();

        for (int size = 1; size < n; size++) {
            for (int j = 0; j < n - size + 1; j++) {
                String s1 = s.substring(j, j + size);
                final int m = multiply(s1);
                if (set.contains(m)) {
                    return false;
                } else {
                    set.add(m);
                }
            }
        }

        return true;
    }

    private static int multiply(String s) {
        return Arrays.stream(s.split(""))
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }
}

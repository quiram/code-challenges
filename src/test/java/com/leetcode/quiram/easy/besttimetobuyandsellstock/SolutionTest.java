package com.leetcode.quiram.easy.besttimetobuyandsellstock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void inputs(int[] prices, int profit) {
        final int actual = subject.maxProfit(prices);
        assertEquals(profit, actual);
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2}, 1)
        );
    }
}
package com.github.quiram.challenges.medium.coinchange;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void
    searchRange(int[] coins, int amount, int result) {
        assertEquals(result, solution.coinChange(coins, amount));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2}, 3, -1),
                Arguments.of(new int[]{1, 2, 5}, 100, 20),
                Arguments.of(new int[]{2, 5, 10, 1}, 27, 4),
                Arguments.of(new int[]{186, 419, 83, 408}, 6249, 20),
                Arguments.of(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864, 24)
        );
    }
}
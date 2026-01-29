package com.github.quiram.challenges.easy.climbingstairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int n, int result) {
        assertEquals(result, solution.climbStairs(n));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, 3)
        );
    }
}
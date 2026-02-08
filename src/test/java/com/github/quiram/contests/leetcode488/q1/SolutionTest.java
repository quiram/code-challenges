package com.github.quiram.contests.leetcode488.q1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int[] nums, int result) {
        assertEquals(result, solution.dominantIndices(nums));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3}, 2),
                Arguments.of(new int[]{4, 1, 2}, 1)
        );
    }
}
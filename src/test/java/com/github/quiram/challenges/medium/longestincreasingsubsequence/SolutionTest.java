package com.github.quiram.challenges.medium.longestincreasingsubsequence;

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
    searchRange(int[] nums, int result) {
        assertEquals(result, solution.lengthOfLIS(nums));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4)
        );
    }
}
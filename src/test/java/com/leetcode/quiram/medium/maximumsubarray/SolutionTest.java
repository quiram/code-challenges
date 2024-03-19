package com.leetcode.quiram.medium.maximumsubarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void maxSubArray(int[] nums, int result) {
        assertEquals(result, subject.maxSubArray(nums));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}, 6)
        );
    }
}
package com.leetcode.quiram.containsduplicate2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void inputs(int[] nums, int k, boolean expected) {
        final boolean actual = subject.containsNearbyDuplicate(nums, k);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 3, true),
                Arguments.of(new int[]{1, 0, 1, 1}, 1, true),
                Arguments.of(new int[]{99, 99}, 2, true),
                Arguments.of(new int[]{2, 2}, 3, true),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3}, 2, false)
        );
    }
}
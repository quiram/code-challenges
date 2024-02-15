package com.leetcode.quiram.twosum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void inputs(int[] nums, int target, int[] output) {
        final int[] actual = subject.twoSum(nums, target);
        assertArrayEquals(output, actual);
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }


}
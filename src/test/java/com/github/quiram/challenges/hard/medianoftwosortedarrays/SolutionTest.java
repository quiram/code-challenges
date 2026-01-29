package com.github.quiram.challenges.hard.medianoftwosortedarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int[] a, int[] b, double result) {
        assertEquals(result, solution.findMedianSortedArrays(a, b));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{2}, new int[]{}, 2.0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}, 9.0),
                Arguments.of(new int[]{3}, new int[]{-2, -1}, -1.0),
                Arguments.of(new int[]{1, 2}, new int[]{-1, 3}, 1.5)
        );
    }
}
package com.github.quiram.challenges.medium.findandlastpositionofelementinsortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int[] nums, int target, int[] result) {
        assertArrayEquals(result, solution.searchRange(nums, target));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4})
        );
    }
}
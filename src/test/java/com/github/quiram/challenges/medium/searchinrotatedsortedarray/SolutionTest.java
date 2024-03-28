package com.github.quiram.challenges.medium.searchinrotatedsortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void search(int[] nums, int target, int result) {
        assertEquals(result, subject.search(nums, target));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 4)
        );
    }
}
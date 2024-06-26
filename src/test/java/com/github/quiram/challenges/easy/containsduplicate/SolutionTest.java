package com.github.quiram.challenges.easy.containsduplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void inputs(int[] nums, boolean expected) {
        final boolean actual = subject.containsDuplicate(nums);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}
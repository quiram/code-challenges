package com.github.quiram.challenges.medium.findminimuminrotatedsortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution subject = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void findMin(int[] nums, int result) {
        assertEquals(result, subject.findMin(nums));
    }

    public static Stream<Arguments> scenarios() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{2, 1}, 1)
        );
    }
}
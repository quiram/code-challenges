package com.github.quiram.challenges.medium.decodeways;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(String s, int result) {
        assertEquals(result, solution.numDecodings(s));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("226", 3)
        );
    }
}
package com.github.quiram.challenges.medium.uniquepaths;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int m, int n, int result) {
        assertEquals(result, solution.uniquePaths(m, n));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, 7, 28),
                Arguments.of(16, 16, 155117520)
        );
    }
}
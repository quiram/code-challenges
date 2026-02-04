package com.github.quiram.challenges.medium.longestcommonsubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void
    searchRange(String text1, String text2, int result) {
        assertEquals(result, solution.longestCommonSubsequence(text1, text2));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("ylqpejqbalahwr", "yrkzavgdmdgtqpg", 3)
        );
    }
}
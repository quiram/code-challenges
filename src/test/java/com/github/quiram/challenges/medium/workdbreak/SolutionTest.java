package com.github.quiram.challenges.medium.workdbreak;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void
    searchRange(String s, List<String> wordDict, boolean result) {
        assertEquals(result, solution.wordBreak(s, wordDict));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("leetcode", List.of("leet", "code"), true)
        );
    }
}
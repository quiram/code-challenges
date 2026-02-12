package com.github.quiram.challenges.medium.generateparenthesis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("data")
    void searchRange(int n, List<String> result) {
        assertEquals(new HashSet<>(result), new HashSet<>(solution.generateParenthesis(n)));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }
}
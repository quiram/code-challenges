package com.github.quiram.challenges.hard.colorfulnumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "3245,true",
            "123,false",
            "326,false",
            "1,true",
            "567,true"
    })
    void isColorfulNumber(int n, boolean result) {
        assertEquals(result, Solution.isColorfulNumber(n));
    }
}
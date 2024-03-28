package com.github.quiram.challenges.easy.ransomnote;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "a,b,false",
            "aa,ab,false",
            "aa,aab,true"
    })
    void test(String ransomNote, String magazineNote, boolean expectedAnswer) {
        final Solution subject = new Solution();
        assertEquals(expectedAnswer, subject.canConstruct(ransomNote, magazineNote));
    }
}
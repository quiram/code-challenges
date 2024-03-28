package com.leetcode.quiram.easy.ransomnote;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Map.entry;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * <a href="https://leetcode.com/problems/ransom-note/description/">383. Ransom Note</a>
 */
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        var ransomNoteLetterCount = letterCount(ransomNote);
        var magazineLetterCount = letterCount(magazine);
        return ransomNoteLetterCount.entrySet().stream()
                .allMatch(entry -> entry.getValue() <= magazineLetterCount.getOrDefault(entry.getKey(), 0));
    }

    private Map<String, Integer> letterCount(String s) {
        final String[] split = s.split("");
        return stream(split)
                .collect(groupingBy(identity()))
                .entrySet().stream()
                .map(entry -> entry(entry.getKey(), entry.getValue().size()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
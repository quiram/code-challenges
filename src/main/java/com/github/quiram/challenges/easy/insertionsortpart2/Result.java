package com.github.quiram.challenges.easy.insertionsortpart2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort2/problem">Insertion Sort - Part 2</a>
 */
class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            final var element = arr.get(i);
            while (j >= 0 && element < arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, element);

            System.out.printf("%s%n", arr.stream().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }

}

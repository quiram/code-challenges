package com.github.quiram.challenges.medium.snakesandladders;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/the-quickest-way-up/problem">Snakes and Ladders: The Quickest Way Up</a>
 */
class Result {

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        // Write your code here
        final Map<Integer, Integer> jumps = new HashMap<>();
        final Map<Integer, Integer> dice = new HashMap<>();
        final Queue<Integer> queue = new LinkedList<>();

        for (List<Integer> ladder : ladders) {
            jumps.put(ladder.get(0), ladder.get(1));
        }

        for (List<Integer> snake : snakes) {
            jumps.put(snake.get(0), snake.get(1));
        }

        dice.put(1, 0);
        queue.add(1);

        while (!queue.isEmpty()) {
            int i = queue.remove();
            int n = dice.get(i);
            for (int j = 1; j <= 6; j++) {
                int next = i + j;
                next = jumps.getOrDefault(next, next);
                if (!dice.containsKey(next) && next <= 100) {
                    dice.put(next, n + 1);
                    queue.add(next);
                }
            }
        }

        return dice.getOrDefault(100, -1);
    }
}

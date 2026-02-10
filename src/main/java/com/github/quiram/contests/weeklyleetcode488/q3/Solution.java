package com.github.quiram.contests.weeklyleetcode488.q3;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.Objects.requireNonNull;

/**
 * <a href="https://leetcode.com/contest/weekly-contest-488/problems/count-subarrays-with-cost-less-than-or-equal-to-k/description/">Q3. Count Subarrays With Cost Less Than or Equal to K</a>
 */
class Solution {
    /**
     * We keep a (left, right) window of candidate arrays. Growing towards the right means:
     * - Max potentially increases, but never decreases
     * - Min potentially decreases, but never increases
     * - Spread (right - left) always increases
     * <p>
     * This means that adding elements to the right will either leave cost the same (if max - min == 0) or increase it (any other case).
     * Therefore, if a particular (left, right) window has a cost > k, increasing the window to the right won't give us any more results,
     * we need to reduce the window from the left instead.
     * <p>
     * When reducing the window from the left we may or may not remove the current max or min, so we need to keep track of the subsequents
     * max and min as we expand the window towards the right.
     */
    public long countSubarrays(int[] nums, long k) {
        final Deque<Integer> minDeq = new ArrayDeque<>();
        final Deque<Integer> maxDeq = new ArrayDeque<>();
        long result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 1. Update the queues after expanding window on the right

            // Remove from the Max tail any numbers lower than the one on the right (they're no longer max)
            while (!maxDeq.isEmpty() && nums[maxDeq.peekLast()] <= nums[right])
                maxDeq.removeLast();
            maxDeq.addLast(right);

            // remove from the Min tail any numbers higher than the one on the right (they're no longer min)
            while (!minDeq.isEmpty() && nums[minDeq.peekLast()] >= nums[right])
                minDeq.removeLast();
            minDeq.addLast(right);

            // 2. Shrink window on the left while invalid
            while (!maxDeq.isEmpty() && !minDeq.isEmpty() && cost(nums[maxDeq.peekFirst()], nums[minDeq.peekFirst()], right, left) > k) {
                if (maxDeq.peekFirst() == left)
                    maxDeq.removeFirst();

                if (requireNonNull(minDeq.peekFirst()) == left)
                    minDeq.removeFirst();

                left++;
            }

            // 3. The window is valid, add all arrays ending at right
            result += right - left + 1;
        }

        return result;
    }

    private long cost(int max, int min, int right, int left) {
        return ((long) (max - min)) * (right - left + 1);
    }
}

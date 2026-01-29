package com.github.quiram.challenges.hard.medianoftwosortedarrays;

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        final int n = a.length;
        final int m = b.length;

        if (n > m) {
            // We need A to be smaller than B
            return findMedianSortedArrays(b, a);
        }

        final int total = n + m;
        final int half = total / 2;
        int low = 0;
        int high = a.length;
        int min1, max1, min2, max2;
        int c1;
        int c2;
        do {
            c1 = (low + high) / 2;
            c2 = half - c1;

            max1 = c1 == 0 ? Integer.MIN_VALUE : a[c1 - 1];
            min1 = c1 == n ? Integer.MAX_VALUE : a[c1];
            max2 = c2 == 0 ? Integer.MIN_VALUE : b[c2 - 1];
            min2 = c2 == m ? Integer.MAX_VALUE : b[c2];

            if (max1 > min2) {
                // Elements left of c1 are higher than right of c2, move cut downwards to reduce its size
                high = c1 - 1;
            } else if (max2 > min1) {
                // elements left of c2 are higher than right of c1, move cut upwards to increase its size
                low = c1 + 1;
            } else {
                // we're good to go
                low = high + 1;
            }
        } while (low <= high);

        double min = Math.min(min1, min2);

        if ((n + m) % 2 == 0) {
            double max = Math.max(max1, max2);
            return (min + max + 0.0) / 2;
        } else {
            return min;
        }
    }
}
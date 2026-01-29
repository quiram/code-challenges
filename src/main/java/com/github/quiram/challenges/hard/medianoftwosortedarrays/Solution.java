package com.github.quiram.challenges.hard.medianoftwosortedarrays;

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        final int n = a.length;
        final int m = b.length;
        double k_th = solve(a, b, n - 1, m - 1, (n + m - 1) / 2);

        if ((n + m) % 2 == 0) {
            final double k1_th = solve(a, b, n - 1, m - 1, (n + m) / 2);
            return (k_th + k1_th) / 2;
        } else {
            return k_th;
        }

    }

    private double solve(int[] a, int[] b, int a_end, int b_end, int k) {
        int a_start = 0;
        int b_start = 0;
        while (a_start <= a_end && b_start <= b_end) {
            int a_mid = (a_end + a_start) / 2;
            int b_mid = (b_end + b_start) / 2;
            int a_median = a[a_mid];
            int b_median = b[b_mid];
            int threshold = a_mid + b_mid + 1;

            if (a_median <= b_median) {
                if (k >= threshold) {
                    // discard lower half of A
                    a_start = a_mid + 1;
                } else {
                    // discard upper half of B
                    b_end = b_mid - 1;
                }
            } else {
                // same, but inverting A and B
                if (k >= threshold) {
                    // discard lower half of B
                    b_start = b_mid + 1;
                } else {
                    // discard upper half of A
                    a_end = a_mid - 1;
                }
            }
        }

        if (a_start > a_end) {
            return b[k - a_start];
        } else {
            return a[k - b_start];
        }
    }
}
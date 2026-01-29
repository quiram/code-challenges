package com.github.quiram.challenges.hard.medianoftwosortedarrays;

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        final int n = a.length;
        final int m = b.length;
        double k_th = solve(a, b, 0, n - 1, 0, m - 1, (n + m - 1) / 2);

        if ((n + m) % 2 == 0) {
            final double k1_th = solve(a, b, 0, n - 1, 0, m - 1, (n + m) / 2);
            return (k_th + k1_th) / 2;
        } else {
            return k_th;
        }

    }

    private double solve(int[] a, int[] b, int a_start, int a_end, int b_start, int b_end, int k) {
        if (a_start > a_end) {
            return b[k - a_start];
        } else if (b_start > b_end) {
            return a[k - b_start];
        }

        int a_mid = (a_end + a_start) / 2;
        int b_mid = (b_end + b_start) / 2;
        int a_median = a[a_mid];
        int b_median = b[b_mid];
        int threshold = a_mid + b_mid + 1;

        if (a_median <= b_median) {
            if (k >= threshold) {
                // discard lower half of A
                return solve(a, b, a_mid + 1, a_end, b_start, b_end, k);
            } else {
                // discard upper half of B
                return solve(a, b, a_start, a_end, b_start, b_mid - 1, k);
            }
        } else {
            // same, but inverting A and B
            if (k >= threshold) {
                // discard lower half of B
                return solve(a, b, a_start, a_end, b_mid + 1, b_end, k);
            } else {
                // discard upper half of A
                return solve(a, b, a_start, a_mid - 1, b_start, b_end, k);
            }
        }
    }
}
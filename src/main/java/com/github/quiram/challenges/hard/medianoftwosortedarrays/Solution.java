package com.github.quiram.challenges.hard.medianoftwosortedarrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int j = 0, k = 0;
        for (int i = 0; i < merged.length; i++) {
            if (j == nums1.length) {
                merged[i] = nums2[k];
                k++;
            } else if (k == nums2.length) {
                merged[i] = nums1[j];
                j++;
            } else if (nums1[j] < nums2[k]) {
                merged[i] = nums1[j];
                j++;
            } else {
                merged[i] = nums2[k];
                k++;
            }
        }

        if (merged.length % 2 == 1)
            return merged[merged.length / 2];
        else
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2] + 0.0) / 2;
    }
}
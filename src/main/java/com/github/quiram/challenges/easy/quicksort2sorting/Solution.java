package com.github.quiram.challenges.easy.quicksort2sorting;


import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/quicksort2/problem">Quicksort 2 - Sorting</a>
 */
public class Solution {

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length);
    }

    static void quickSort(int[] ar, int ini, int end) {
        if (end - ini <= 1) {
            return;
        }

        int pivot = ar[ini];
        int partitionPoint = ini;
        for (int i = ini + 1; i < end; i++) {
            int element = ar[i];
            if (element < pivot) {
                partitionPoint++;
                int j = i - 1;
                while (j >= 0 && ar[j] >= pivot) {
                    ar[j + 1] = ar[j];
                    j--;
                }
                ar[j + 1] = element;
            }
        }

        quickSort(ar, ini, partitionPoint);
        quickSort(ar, partitionPoint + 1, end);
        printArray(ar, ini, end);
    }


    static void printArray(int[] ar, int ini, int end) {
        for (int i = ini; i < end; i++) {
            int n = ar[i];
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }
}

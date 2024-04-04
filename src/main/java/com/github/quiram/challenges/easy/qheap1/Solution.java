package com.github.quiram.challenges.easy.qheap1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/qheap1/problem">QHEAP1</a>
 */
public class Solution {
    public static class Heap {
        int[] array;
        int lastIndex;

        public Heap() {
            array = new int[10];
            lastIndex = -1;
        }

        public void insert(int value) {
            if (lastIndex == array.length - 1) {
                array = Arrays.copyOf(array, array.length * 2);
            }

            lastIndex++;
            array[lastIndex] = value;

            //promote value
            int child = lastIndex;
            int parent = (child - 1) / 2;
            while (child > parent && array[parent] > value) {
                array[child] = array[parent];
                array[parent] = value;
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public void remove(int value) {
            int i = 0;
            while (array[i] != value) {
                i++;
            }

            array[i] = array[lastIndex];
            value = array[i];
            lastIndex--;

            int parent = i;

            boolean balanced = false;
            while (!balanced) {
                int child1 = 2 * parent + 1;
                int child2 = 2 * parent + 2;
                int child;
                if (child1 > lastIndex) {
                    child = -1;
                } else if (child2 > lastIndex || array[child1] < array[child2]) {
                    child = child1;
                } else {
                    child = child2;
                }

                if (child > 0 && array[parent] > array[child]) {
                    array[parent] = array[child];
                    array[child] = value;
                    parent = child;
                } else {
                    balanced = true;
                }
            }
        }

        public void printTop() {
            System.out.println(array[0]);
        }
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Heap heap = new Heap();

        for (int i = 0; i < q; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> heap.insert(scanner.nextInt());
                case 2 -> heap.remove(scanner.nextInt());
                case 3 -> heap.printTop();
                default -> throw new RuntimeException("invalid command: " + command);
            }
        }
    }
}

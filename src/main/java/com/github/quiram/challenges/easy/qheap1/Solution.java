package com.github.quiram.challenges.easy.qheap1;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/qheap1/problem">QHEAP1</a>
 */
public class Solution {

    public static class HeapNode {
        int data;
        HeapNode left;
        HeapNode right;

        public HeapNode(int data) {
            this.data = data;
        }
    }

    public static HeapNode insert(HeapNode node, int value) {
        if (node == null || value < node.data) {
            HeapNode newRoot = new HeapNode(value);
            newRoot.left = node;
            return newRoot;
        }

        if (node.left == null) {
            node.left = insert(node.left, value);
        } else if (node.right == null) {
            node.right = insert(node.right, value);
        } else if (node.left.data > node.right.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public static HeapNode remove(HeapNode node, int value) {
        if (node == null || value < node.data) {
            // we've gone past, not in this branch
            return node;
        }

        if (value == node.data) {
            // remove and rebalance
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            HeapNode preservedNode;
            HeapNode promotedNode;

            if (node.left.data < node.right.data) {
                promotedNode = node.left;
                preservedNode = node.right;
            } else {
                promotedNode = node.right;
                preservedNode = node.left;
            }

            HeapNode newRoot = new HeapNode(promotedNode.data);
            newRoot.left = preservedNode;
            newRoot.right = remove(promotedNode, promotedNode.data);
            return newRoot;
        }

        node.left = remove(node.left, value);
        node.right = remove(node.right, value);

        return node;
    }

    public static void print(HeapNode node) {
        System.out.println(node.data);
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        HeapNode root = null;

        for (int i = 0; i < q; i++) {
            int command = scanner.nextInt();
            int value;
            switch (command) {
                case 1 -> {
                    value = scanner.nextInt();
                    root = insert(root, value);
                }
                case 2 -> {
                    value = scanner.nextInt();
                    root = remove(root, value);
                }
                case 3 -> {
                    print(requireNonNull(root));
                }
            }
        }
    }
}
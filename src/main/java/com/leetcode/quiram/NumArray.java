package com.leetcode.quiram;

import java.util.stream.IntStream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

class NumArray {

    private final Block[] blocks;

    public NumArray(int[] nums) {
        final int n = (int) ceil(sqrt(nums.length));
        blocks = IntStream.range(0, n)
                .mapToObj(i -> new Block(buildSubArray(nums, n, i))).toList()
                .toArray(new Block[0]);
    }

    private static int[] buildSubArray(int[] nums, int n, int i) {
        final int from = i * n;
        final int to = i * n + n;

        return from < nums.length ? copyOfRange(nums, from, to) : new int[nums.length];
    }

    public void update(int index, int val) {
        int block = index / blocks.length;
        int indexInBlock = index % blocks.length;
        blocks[block].update(indexInBlock, val);
    }

    public int sumRange(int left, int right) {
        int firstBlock = left / blocks.length;
        int firstBlockIndex = left - firstBlock * blocks.length;
        int lastBlock = right / blocks.length;
        int lastBlockIndex = right - lastBlock * blocks.length;

        if (firstBlock == lastBlock) {
            return blocks[firstBlock].sumRange(firstBlockIndex, lastBlockIndex);
        }

        final int firstBlockSum = blocks[firstBlock].sumRange(firstBlockIndex, blocks.length - 1);

        final int innerBlocksSum = lastBlock > firstBlock + 1 ?
                stream(blocks, firstBlock + 1, lastBlock)
                        .mapToInt(Block::getSum)
                        .reduce(0, Integer::sum)
                : 0;

        final int lastBlockSum = blocks[lastBlock].sumRange(0, lastBlockIndex);

        return innerBlocksSum + firstBlockSum + lastBlockSum;
    }

    static class Block {
        private final int[] nums;
        private int sum;
        private boolean dirty = true;

        Block(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
            dirty = true;
        }

        public int sumRange(int left, int right) {
            return stream(nums, left, right + 1).reduce(0, Integer::sum);
        }

        private void preCalculateSum() {
            sum = stream(nums).reduce(0, Integer::sum);
        }

        public int getSum() {
            if (dirty) {
                preCalculateSum();
                dirty = false;
            }
            return sum;
        }
    }
}

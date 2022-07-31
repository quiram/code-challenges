

package com.leetcode.quiram;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.util.Arrays.stream;

class NumArray {

    private final int[] nums;
    private final int[] sums;
    private final int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = (int) ceil(sqrt(nums.length));
        sums = new int[n];
        for (int i = 0; i < n; i++) {
            calculateBlock(i);
        }
    }

    private void calculateBlock(int i) {
        sums[i] = 0;
        for (int j = i * n; j < (i + 1) * n && j < nums.length; j++) {
            sums[i] += nums[j];
        }
    }

    public void update(int index, int val) {
        int block = index / n;
        sums[block] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int firstBlock = left / n;
        int lastBlock = right / n;

        if (firstBlock == lastBlock) {
            return sumSubRange(left, right);
        }

        final int firstBlockSum = sumSubRange(left, (firstBlock + 1) * n - 1);

        final int innerBlocksSum = lastBlock > firstBlock + 1 ?
                stream(sums, firstBlock + 1, lastBlock).reduce(0, Integer::sum)
                : 0;

        final int lastBlockSum = sumSubRange(lastBlock * n, right);

        return innerBlocksSum + firstBlockSum + lastBlockSum;
    }

    private int sumSubRange(int left, int right) {
        return stream(nums, left, right + 1).reduce(0, Integer::sum);
    }
}


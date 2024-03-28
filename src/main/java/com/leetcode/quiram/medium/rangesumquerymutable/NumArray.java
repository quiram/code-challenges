

package com.leetcode.quiram.medium.rangesumquerymutable;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-mutable/description/">307. Range Sum Query - Mutable</a>
 */
class NumArray {

    private final int[] nums;
    private final int[] sums;
    private final int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = (int) ceil(sqrt(nums.length));
        sums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i * n; j < (i + 1) * n && j < this.nums.length; j++) {
                sums[i] += this.nums[j];
            }
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
            return sumSubRange(nums, left, right);
        }

        final int firstBlockSum = sumSubRange(nums, left, (firstBlock + 1) * n - 1);

        final int innerBlocksSum = lastBlock > firstBlock + 1 ?
                sumSubRange(sums, firstBlock + 1, lastBlock - 1)
                : 0;

        final int lastBlockSum = sumSubRange(nums, lastBlock * n, right);

        return innerBlocksSum + firstBlockSum + lastBlockSum;
    }

    private int sumSubRange(int[] array, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += array[i];
        }
        return result;
    }
}


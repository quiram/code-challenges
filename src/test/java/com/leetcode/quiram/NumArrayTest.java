package com.leetcode.quiram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumArrayTest {
    @Test
    void test() {
        final NumArray obj = new NumArray(new int[]{1, 3, 5});
        assertEquals(9, obj.sumRange(0, 2));
        obj.update(1, 2);
        assertEquals(8, obj.sumRange(0, 2));
        assertEquals(3, obj.sumRange(0, 1));
    }

    @Test
    void test2() {
        /*
        ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
[[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
         */
        final NumArray subject = new NumArray(new int[]{0, 9, 5, 7, 3});
        assertEquals(3, subject.sumRange(4, 4));
        assertEquals(15, subject.sumRange(2, 4));
        assertEquals(7, subject.sumRange(3, 3));
    }

    @Test
    void test3() {
        /*
        ["NumArray","sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
[[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
         */
        final NumArray subject = new NumArray(new int[]{-28, -39, 53, 65, 11, -56, -65, -39, -43, 97});
        subject.update(9, 27);
        subject.update(1, -82);
        subject.update(3, -72);

        assertEquals(-293, subject.sumRange(1, 8));
    }
}
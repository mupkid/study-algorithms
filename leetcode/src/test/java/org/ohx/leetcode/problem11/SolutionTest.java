package org.ohx.leetcode.problem11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void testMaxAreaStandardCase() {
        // 测试经典案例
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        assertEquals(expected, Solution.maxArea(height));
    }

    @Test
    void testTwoElements() {
        // 测试最小数组长度（2个元素）
        int[] height = {1, 3};
        assertEquals(1, Solution.maxArea(height));
    }

    @Test
    void testEqualHeights() {
        // 测试高度相等时的指针移动逻辑
        int[] height = {3, 1, 2, 3};
        assertEquals(9, Solution.maxArea(height));
    }

    @Test
    void testMonotonicArray() {
        // 测试单调递增数组
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(4, Solution.maxArea(height));
    }

    @Test
    void testMiddlePeak() {
        // 测试中间存在峰值的情况
        int[] height = {4, 3, 2, 1, 4};
        assertEquals(16, Solution.maxArea(height));
    }

    @Test
    void testAllEqualHeights() {
        // 测试所有高度相等的情况
        int[] height = {5, 5, 5, 5};
        assertEquals(15, Solution.maxArea(height));
    }
}

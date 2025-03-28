package org.ohx.leetcode.problem15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    // 单元测试设计
    // 被测函数分析：
    // threeSum函数通过排序和双指针法找出所有三元组，使其和为0。关键点包括：
    // 1. 数组排序后遍历每个元素作为第一个数。
    // 2. 去重逻辑：跳过重复的i值和找到解后移动指针时跳过重复元素。
    // 3. 提前终止条件：当第一个数>0时，直接返回结果。
    // 4. 双指针移动逻辑：根据sum与目标值比较决定移动方向。

    // 分支覆盖分析：
    // - nums[i] > 0 的条件分支（提前返回）
    // - i>0时跳过重复元素的条件判断
    // - 双指针循环中的sum等于、小于、大于目标值的三种情况
    // - 找到解后移动指针时的重复元素跳过逻辑

    // 测试用例分析：
    // 1. 正常情况：存在多个解（如[-1,0,1,2,-1,-4]）
    // 2. 单一解：全零数组（如[0,0,0]）
    // 3. 无解：所有元素和无法为0（如[1,2,3]）
    // 4. 数组长度不足3（如[1,2]）
    // 5. 重复元素但有效解（如[-2,0,0,2,2]）
    // 6. 边界情况：包含0时的正确处理
    // 7. 提前终止条件触发（如第一个元素>0）

    // Mock需求分析：
    // 函数内部调用Arrays.sort()是静态方法，但根据要求不mock工具类的静态方法，因此无需mock。

    @Test
    public void testThreeSumWithMultipleSolutions() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result = solution.threeSum(nums);
        result.sort((a, b) -> a.toString().compareTo(b.toString()));
        expected.sort((a, b) -> a.toString().compareTo(b.toString()));
        assertEquals(expected, result);
    }

    @Test
    public void testThreeSumWithSingleZero() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 0, 0));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testThreeSumWithNoSolution() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.threeSum(nums));
    }

    @Test
    public void testShortArray() {
        int[] nums = {1, 2};
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.threeSum(nums));
    }

    @Test
    public void testDuplicateElements() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2, 0, 2));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testBoundaryCaseWithZero() {
        int[] nums = {-0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 0, 0));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testEarlyTermination() {
        int[] nums = {2, 3, 4};
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.threeSum(nums));
    }
}

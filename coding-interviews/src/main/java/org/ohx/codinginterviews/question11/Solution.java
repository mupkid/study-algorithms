package org.ohx.codinginterviews.question11;

/**
 * 面试题11：旋转数组的最小数字
 * <p>
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/4/18 22:05
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            if (array[first] < array[last]) {
                // 已经是有序数组，提前退出
                return array[first];
            }

            int mid = first + ((last - first) >> 1);
            if (array[mid] > array[last]) {
                // 中间的大于最右边的，最小的数在右区间
                first = mid + 1;
            } else if (array[mid] < array[last]) {
                // 中间的小于最右边的，最小的数在左区间
                last = mid;
            } else {
                // 不能确定，先逐渐缩小计算区间
                --last;
            }
        }

        return array[first];
    }
}

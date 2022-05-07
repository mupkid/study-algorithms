package org.ohx.codinginterviews.question21;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * <p>
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author mudkip
 * @date 2022/5/7 15:42
 */
public class ReorderArray {
    public static void reorderOddEvent(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // 向后移动头指针，直至指向偶数
            while (start < end && (array[start] & 1) != 0) {
                start++;
            }

            // 向后移动尾指针，直至指向奇数
            while (start < end && (array[end] & 1) == 0) {
                end--;
            }

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }
}

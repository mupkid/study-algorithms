package org.ohx.codinginterviews.question21;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * <p>
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 牛客网版本
 * 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author mudkip
 * @date 2022/5/7
 */
public class Solution {
    public int[] reOrderArray(int[] array) {
        // 首先是对数值长度进行特判
        if (array == null || array.length == 0) {
            return array;
        }
        // 记录已经是奇数的位置
        int j = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            // 如果该值为偶数
            if (array[i] % 2 != 0) {
                // 该值为奇数
                int k = i;
                while (k > j) {
                    // 这区间整体向后移动一位
                    array[k] = array[k - 1];
                    k--;
                }
                // 移位之后将对应的值赋值
                array[k] = temp;
                j++;
            }
        }
        // 返回结果数数组
        return array;
    }
}

package org.ohx.codinginterviews.question4;

import java.util.Objects;

/**
 * 面试题4：二维数组中的查找
 * <p>
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 *
 * @author mudkip
 * @date 2022/4/17 10:19
 */
public class FindInPartiallySortedMatrix {
    /**
     * 从右上角开始查找，每次判断剔除一整行或一整列
     * <p>
     * 时间复杂度O(row+column)，空间复杂度O(1)
     *
     * @param target 目标数字
     * @param array  二维数组
     * @return 找到返回true，找不到返回false
     */
    public static boolean find(int target, int[][] array) {
        if (Objects.isNull(array)) {
            return false;
        }
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int columns = array[0].length;
        if (columns == 0) {
            return false;
        }

        for (int i = 0, j = columns - 1; i < rows && j >= 0; ) {
            if (array[i][j] < target) {
                i++;
            } else if (array[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}

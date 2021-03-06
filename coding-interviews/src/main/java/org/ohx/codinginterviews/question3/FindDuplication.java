package org.ohx.codinginterviews.question3;

import java.util.Objects;

/**
 * 面试题3（一）：找出数组中重复的数字
 * <p>
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。存在不合法的输入的话输出-1。
 *
 * @author mudkip
 * @date 2022/4/16 21:12
 */
public class FindDuplication {
    /**
     * 时间O(n)，空间O(1)
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int duplicate(int[] numbers) {
        // 不合法输入校验
        if (Objects.isNull(numbers) || numbers.length == 0) {
            return -1;
        }
        for (int number : numbers) {
            if (number < 0 || number > numbers.length - 1) {
                return -1;
            }
        }

        // 数组中的数字都在0~n-1的范围内，如果这个数组中没有重复的数字，
        // 那么排序后数字i将出现在下标i的位置
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 交换
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 时间O(n)，空间O(n)
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int duplicate2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int[] res = new int[numbers.length];
        for (int number : numbers) {
            res[number]++;
            if (res[number] == 2) {
                return number;
            }
        }
        return -1;
    }
}

package org.ohx.codinginterviews.question17;

/**
 * 面试题17：打印1到最大的n位数
 * <p>
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/5/2
 */
public class Solution {
    /**
     * @param n int整型 最大位数
     * @return int整型一维数组
     */
    public int[] printNumbers(int n) {
        // 可用快速幂找到该n+1位数的最小数字
        int end = 1;
        for (int i = 1; i <= n; i++) {
            end *= 10;
        }

        //从1遍历到n+1位数的最小数字输出
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}

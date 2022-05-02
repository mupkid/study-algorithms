package org.ohx.codinginterviews.question16;

/**
 * 面试题16：数值的整数次方
 * <p>
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/5/2
 */
public class Solution {
    /**
     * 快速幂
     *
     * @param base     底数
     * @param exponent 指数
     * @return 幂
     */
    public double power(double base, int exponent) {
        // 处理负数次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1;
        while (exponent != 0) {
            // 可以再往上乘一个
            if ((exponent & 1) == 1) {
                res *= base;
            }
            // 叠加
            base *= base;
            // 减少乘次数
            exponent >>= 1;
        }
        return res;
    }
}
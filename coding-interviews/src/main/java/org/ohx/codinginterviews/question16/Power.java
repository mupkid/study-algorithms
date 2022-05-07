package org.ohx.codinginterviews.question16;

/**
 * 面试题16：数值的整数次方
 * <p>
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author mudkip
 * @date 2022/5/1
 */
public class Power {
    /**
     * 递归求幂
     *
     * @param base     底数
     * @param exponent 指数
     * @return 幂
     */
    public static double recursionPower(double base, int exponent) {
        return exponent > 0 ? recursionPow(base, exponent) : recursionPow(1 / base, -exponent);
    }

    private static double recursionPow(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = recursionPow(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }

        return result;
    }

    /**
     * 快速幂
     *
     * @param base     底数
     * @param exponent 指数
     * @return 幂
     */
    public static double quickPower(double base, int exponent) {
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

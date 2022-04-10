package org.ohx.codinginterviews.question10;

/**
 * 面试题10：斐波那契数列
 * <p>
 * 输入n，求斐波那契数列的第n项
 *
 * @author mudkip
 * @date 2022/4/10 14:56
 */
public class Fibonacci {
    /**
     * 递归实现，
     * 效率相当慢
     *
     * @param n 输入
     * @return 斐波那契数列的第n项
     */
    public static long solution1(long n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    /**
     * 从下往上算，能够保存中间项，
     * 时间复杂度是O(n)
     *
     * @param n 输入
     * @return 斐波那契数列的第n项
     */
    public static long soulution2(int n) {
        if (n < 2) {
            return n;
        }
        long fibMinus1 = 1;
        long fibMinus2 = 0;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fibMinus1 + fibMinus2;
            fibMinus2 = fibMinus1;
            fibMinus1 = fib;
        }

        return fib;
    }
}

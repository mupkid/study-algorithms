package org.ohx.codinginterviews.question10;

/**
 * 扩展提：青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * <p>
 * 解法：本题就是变种的斐波那契数列
 *
 * @author mudkip
 * @date 2022/4/10 15:30
 */
public class FrogJump {
    /**
     * 参照斐波那契数列的解法
     *
     * @param n 输入
     * @return 解法数量
     */
    public static long solution(int n) {
        if (n < 3) {
            return n;
        }
        long fibMinus1 = 1;
        long fibMinus2 = 0;
        long fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = fibMinus1 + fibMinus2;
            fibMinus2 = fibMinus1;
            fibMinus1 = fib;
        }

        return fib;
    }
}

package org.ohx.codinginterviews.question14;

/**
 * 面试题14：剪绳子
 * <p>
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/4/20 22:36
 */
public class Solution {
    public int cutRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) Math.pow(3, (n - 4) / 3) * 4;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }
}

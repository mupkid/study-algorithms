package org.ohx.codinginterviews.question15;

/**
 * 面试题15：二进制中1的个数
 * <p>
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 *
 * @author mudkip
 * @date 2022/4/21 23:22
 */
public class NumberOfOneInBinary {
    public static int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}

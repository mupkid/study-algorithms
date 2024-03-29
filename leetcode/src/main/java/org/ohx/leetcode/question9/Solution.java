package org.ohx.leetcode.question9;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution {

    public boolean isPalindrome(int x) {
        // 负数或者个位为0的数不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }
}

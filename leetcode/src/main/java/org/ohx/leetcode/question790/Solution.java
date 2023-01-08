package org.ohx.leetcode.question790;

/**
 * @author mudkip
 * @date 2022/11/12
 */
public class Solution {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }

        long num0 = 1;
        long num1 = 1;
        long num2 = 2;
        long num3 = 5;
        for (int i = 3; i <= n; i++) {
            num3 = (num2 * 2 + num0) % MOD;
            num0 = num1;
            num1 = num2;
            num2 = num3;
        }

        return (int) num3;
    }
}

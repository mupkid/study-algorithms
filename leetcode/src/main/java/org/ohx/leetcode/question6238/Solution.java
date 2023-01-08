package org.ohx.leetcode.question6238;

/**
 * @author mudkip
 * @date 2022/11/12
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        StringBuilder zeroSb = new StringBuilder();
        for (int i = 0; i < zero; i++) {
            zeroSb.append('0');
        }
        StringBuilder oneSb = new StringBuilder();
        for (int i = 0; i < one; i++) {
            oneSb.append('1');
        }

        return recursive(low, high, new StringBuilder(), zeroSb.toString(), oneSb.toString());
    }

    public int recursive(int low, int high, StringBuilder sb, String zero, String one) {
        if (sb.length() > high) {
            return 0;
        }

        int count = 0;
        if (sb.length() >= low) {
            count++;
        }
        sb.append(zero);
        count += recursive(low, high, sb, zero, one);
        sb.delete(sb.length() - zero.length(), sb.length());
        sb.append(one);
        count += recursive(low, high, sb, zero, one);
        sb.delete(sb.length() - one.length(), sb.length());

        return count % MOD;
    }
}

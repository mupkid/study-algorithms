package org.ohx.leetcode.problem6319;

/**
 * @author mudkip
 * @date 2023/3/19
 */
public class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }
}

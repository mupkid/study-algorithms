package org.ohx.leetcode.problem1017;

/**
 * @author mudkip
 * @date 2023/4/6
 */
class Solution {
    private static final int MAX = 0b1010101010101010101010101010101;

    public String baseNeg2(int n) {
        return Integer.toBinaryString(MAX ^ MAX - n);
    }
}

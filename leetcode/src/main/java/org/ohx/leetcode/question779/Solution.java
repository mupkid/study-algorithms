package org.ohx.leetcode.question779;

/**
 * @author mudkip
 * @date 2022/10/20
 */
public class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}

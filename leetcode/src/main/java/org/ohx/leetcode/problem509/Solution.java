package org.ohx.leetcode.problem509;

/**
 * @author mudkip
 * @date 2023/4/6
 */
public class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int n0 = 0;
        int n1 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = n0 + n1;
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }
}

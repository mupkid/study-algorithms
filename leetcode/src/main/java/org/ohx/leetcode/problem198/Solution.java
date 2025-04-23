package org.ohx.leetcode.problem198;

public class Solution {
    public int rob(int[] nums) {
        int f0 = 0;
        int f1 = 0;
        for (int n : nums) {
            int f2 = Math.max(f0 + n, f1);
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
}

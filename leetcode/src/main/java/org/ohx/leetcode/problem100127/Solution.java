package org.ohx.leetcode.problem100127;

public class Solution {
    public long distributeCandies(int n, int limit) {
        if (n / 3 > limit) {
            return 0L;
        }

        long result = 0L;
        for (int i = limit; i >= 0; i--) {
            for (int j = n - limit; j >= 0; j--) {
                result++;
            }
        }
        return result;
    }
}

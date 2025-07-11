package org.ohx.leetcode.problem100125;

public class Solution {
    public int distributeCandies(int n, int limit) {
        if (n / 3 > limit) {
            return 0;
        }

        int result = 0;
        for (int i = limit; i >= 0; i--) {
            int j = Math.min(n - limit, limit);
            for (; j >= 0; j--) {
                if (n - i - j <= limit) {
                    result++;
                }
            }
        }
        return result;
    }
}

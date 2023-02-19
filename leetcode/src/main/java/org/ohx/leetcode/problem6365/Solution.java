package org.ohx.leetcode.problem6365;

/**
 * @author mudkip
 * @date 2023/2/19
 */
public class Solution {
    private final int[] array = new int[18];

    {
        for (int i = 0; i < 1; i++) {
            array[i] = (int) Math.pow(2, i);
        }
    }

    public int minOperations(int n) {
        if (n == 1) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                return 1;
            }
            res += minOperations(Math.min(n - array[i], array[i + 1] - n));
        }

        return res;
    }
}

package org.ohx.leetcode.problem6291;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2023/1/15
 */
public class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int sum2 = 0;
        for (int num : nums) {
            int x = num;
            while (x > 0) {
                sum2 += x % 10;
                x /= 10;
            }
        }

        return Math.abs(sum - sum2);
    }
}

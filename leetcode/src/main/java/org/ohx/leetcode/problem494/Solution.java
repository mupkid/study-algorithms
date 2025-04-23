package org.ohx.leetcode.problem494;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }

        target /= 2;
        int[] dp = new int[target + 1];
        // 边界条件
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }
}

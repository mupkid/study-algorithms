package org.ohx.codinginterviews.problem47;

/**
 * @author mudkip
 * @date 2023/3/8
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int length = grid[0].length;
        int[] dp = new int[length + 1];
        for (int[] row : grid) {
            for (int i = 0; i < length; i++) {
                dp[i + 1] = row[i] + Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[length];
    }
}

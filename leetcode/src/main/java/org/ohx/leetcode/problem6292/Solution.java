package org.ohx.leetcode.problem6292;

/**
 * @author mudkip
 * @date 2023/1/15
 */
public class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] nums = new int[n][n];

        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    nums[i][j]++;
                }
            }
        }

        return nums;
    }
}

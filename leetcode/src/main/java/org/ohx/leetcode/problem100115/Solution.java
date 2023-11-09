package org.ohx.leetcode.problem100115;

public class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean isWinner = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (grid[i][j] != 1) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return i;
            }
        }
        return -1;
    }
}

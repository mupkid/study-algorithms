package org.ohx.leetcode.problem100116;

public class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] isWinenr = new boolean[n];
        for (int[] edge : edges) {
            isWinenr[edge[1]] = true;
        }
        int res = -1;
        for (int i = 0; i < isWinenr.length; i++) {
            if (!isWinenr[i]) {
                if (res != -1) {
                    return -1;
                }
                res = i;
            }
        }
        return res;
    }
}

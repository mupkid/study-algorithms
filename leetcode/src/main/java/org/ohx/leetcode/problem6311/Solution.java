package org.ohx.leetcode.problem6311;

/**
 * @author mudkip
 * @date 2023/3/4
 */
class Solution {
    public long coloredCells(long n) {
        return 1 + 4 * (n - 1) + 2 * (n - 1) * (n - 2);
    }
}

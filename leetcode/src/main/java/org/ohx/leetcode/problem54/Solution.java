package org.ohx.leetcode.problem54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;;
        int n = matrix[0].length;
        int size = m * n;
        List<Integer> ans = new ArrayList<>(m * n);
        int i = 0;
        int j = -1; // 从 (0, -1) 开始
        for (int di = 0; ans.size() < size; di = (di + 1) % 4) {
            // 走 n 步（注意 n 会减少）
            for (int k = 0; k < n; k++) {
                // 先走一步
                i += DIRS[di][0];
                j += DIRS[di][1];
                ans.add(matrix[i][j]);
            }

            // 减少后面的步数
            int tmp = n;
            n = m - 1;
            m = tmp;
        }
        return ans;
    }
}

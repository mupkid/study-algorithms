package org.ohx.leetcode.problem1223;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2023/2/10
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int m = rollMax.length; // 6
        var f = new int[n][m];
        var s = new int[n];
        Arrays.fill(f[0], 1);
        s[0] = m;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int res = s[i - 1], mx = rollMax[j];
                if (i > mx) res -= s[i - mx - 1] - f[i - mx - 1][j];
                else if (i == mx) --res;
                f[i][j] = (res % MOD + MOD) % MOD; // 防止出现负数
                s[i] = (s[i] + f[i][j]) % MOD;
            }
        }
        return s[n - 1];
    }
}

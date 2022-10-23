package org.ohx.leetcode.question904;

/**
 * @author mudkip
 * @date 2022/10/17
 */
public class Solution {
    public int totalFruit(int[] fs) {
        int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) {
                tot++;
            }
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) {
                    tot--;
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

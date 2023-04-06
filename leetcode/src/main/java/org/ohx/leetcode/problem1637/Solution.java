package org.ohx.leetcode.problem1637;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mudkip
 * @date 2023/4/6
 */
public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }
}

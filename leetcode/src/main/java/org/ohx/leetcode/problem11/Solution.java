package org.ohx.leetcode.problem11;

/**
 * @author mudkip
 * @since 2021-03-12
 */
public class Solution {
    public static int maxArea(int[] height) {
        int ans = 0, l = 0, r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}

package org.ohx.leetcode.problem42;

public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int preMax = 0, sufMax = 0;
        while (left <= right) {
            // left == right 时，也能算当前这个位置的容量
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                // 左边的最大值小于右边的最大值，说明高度已经确定，可以右移
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }
}

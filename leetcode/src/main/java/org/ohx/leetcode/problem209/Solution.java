package org.ohx.leetcode.problem209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }

            // 为什么这里要加 if，因为上面的循环不一定会执行，那么此时 sum 有可能是小于 target 的
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans < nums.length + 1 ? ans : 0;
    }
}

package org.ohx.leetcode.problem1800;

/**
 * @author mudkip
 * @date 2022/10/7
 */
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for (int i = 1, cur = nums[0]; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}

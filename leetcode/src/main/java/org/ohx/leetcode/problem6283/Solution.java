package org.ohx.leetcode.problem6283;

/**
 * @author mudkip
 * @date 2023/1/8
 */
public class Solution {
    public int maximumCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            return 0;
        }

        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return nums.length;
        }

        int plus = nums.length - 1;
        int minus = 0;
        while (nums[minus + 1] < 0 || nums[plus - 1] > 0) {
            if (nums[minus + 1] < 0) {
                minus++;
            }
            if (nums[plus - 1] > 0) {
                plus--;
            }
        }
        return Math.max(minus + 1, nums.length - plus);
    }
}

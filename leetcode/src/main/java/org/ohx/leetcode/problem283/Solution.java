package org.ohx.leetcode.problem283;

/**
 * @author mudkip
 * @date 2023/4/16
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i0];
                nums[i0] = nums[i];
                nums[i] = temp;
                i0++;
            }
        }
    }
}

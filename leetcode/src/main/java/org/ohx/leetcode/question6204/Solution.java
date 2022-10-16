package org.ohx.leetcode.question6204;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/10/16
 */
public class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j && nums[i] < 0 && nums[j] > 0) {
            int abs1 = Math.abs(nums[i]);
            int abs2 = Math.abs(nums[j]);
            if (abs1 == abs2) {
                return nums[j];
            } else if (abs1 > abs2) {
                i++;
            } else {
                j--;
            }
        }
        return -1;
    }
}

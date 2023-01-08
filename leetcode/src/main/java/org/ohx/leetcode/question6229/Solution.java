package org.ohx.leetcode.question6229;

/**
 * @author mudkip
 * @date 2022/11/6
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < length + 1; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }

        return nums;
    }
}

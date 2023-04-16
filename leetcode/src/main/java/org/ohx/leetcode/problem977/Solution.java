package org.ohx.leetcode.problem977;

/**
 * @author mudkip
 * @date 2023/4/16
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        for(int i = right; left <= right; i--) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                result[i] = (int) Math.pow(nums[left++], 2);
            } else {
                result[i] = (int) Math.pow(nums[right--], 2);
            }
        }
        return result;
    }
}

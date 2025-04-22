package org.ohx.leetcode.problem34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = lowerBound(nums, target + 1);
        return new int[]{left, right - 1};
    }

    public int lowerBound(int[] nums, int target) {
        int low = -1, high = nums.length;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}

package org.ohx.codinginterviews.problem53;

/**
 * @author mudkip
 * @date 2023/3/8
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left == nums[left] ? nums.length : left;
    }
}

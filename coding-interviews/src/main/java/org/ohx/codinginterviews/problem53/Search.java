package org.ohx.codinginterviews.problem53;

/**
 * @author mudkip
 * @date 2023/3/8
 */
public class Search {
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            } else if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }

            if (nums[right] == target) {
                count++;
            } else if (nums[right] < target){
                break;
            }
            right--;
        }
        return count;
    }
}

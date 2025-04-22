package org.ohx.leetcode.problem33;

public class Solution {
    public int search(int[] nums, int target) {
        int low = -1, high = nums.length;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (check(nums, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high == nums.length || nums[high] != target ? -1 : high;
    }

    /**
     * 检查 target 在 mid 的 左边还是右边
     *
     * @param nums
     * @param i
     * @param target
     * @return true 表示 target 在 mid 的左边，false 表示 target 在 mid 的右边
     */
    private boolean check(int[] nums, int i, int target) {
        int end = nums[nums.length - 1];
        // 右边是不是连续的
        return nums[i] > end
                // 右边不连续，target 如果在  mid 和 end 之间，说明 target 在左边
                ? nums[i] >= target && target > end
                // 右边连续，如果 target 小于 mid 或者 target 大于 end，说明 target 在左边
                : target > end || target <= nums[i];
    }
}

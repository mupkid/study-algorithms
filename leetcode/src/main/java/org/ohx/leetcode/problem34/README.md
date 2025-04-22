# [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

## 二分查找

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = lowerBound(nums, target + 1) - 1;
        return new int[]{left, right};
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
```
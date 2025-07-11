# [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/description/)

## 二分查找

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
```

对比这两种写法

```java
class Solution {
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
        return -1;
    }

    private boolean check(int[] nums, int i, int target) {
        int end = nums[nums.length - 1];
        return nums[i] > end
                ? nums[i] > target && target > end
                : target > end || target < nums[i];
    }
}
```

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = -1, high = nums.length;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (check(nums, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        // high 最终一定会在 target 的位置或者没有移动过
        return high == nums.length || nums[high] != target ? -1 : high;
    }

    private boolean check(int[] nums, int i, int target) {
        int end = nums[nums.length - 1];
        // 只关注有序的那一侧
        // 如果 nums[i] == target，那么下面的判断都是返回 true，移动的是 high
        return nums[i] > end
                ? target <= nums[i] && target > end
                : target <= nums[i] || target > end;
    }
}
```
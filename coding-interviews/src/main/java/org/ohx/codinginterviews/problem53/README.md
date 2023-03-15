# 面试题53（一）

[力扣 剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

```java
public int search(int[] nums, int target) {
    int count = 0;
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;
    while (low <= high) {
        mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            count++;
            for(int j = mid - 1 ; j >=0 && nums[j] == target; j--) {
                count++;
            }
            for(int j = mid + 1 ; j < nums.length && nums[j] == target; j++) {
                count++;
            }
            break;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return count;
}
```

相当于第一个 target + 1 的下标减去第一个 target 的下标的值。

```java
class Solution {
    private int lowerBound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int search(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = lowerBound(nums, target + 1);
        return right - left;
    }
}
```

# 面试题53（二）

[力扣 剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/)

```java
public int missingNumber(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    int mid;

    while (low <= high) {
        mid = low + ((high - low) >> 1);
        if (nums[mid] == mid) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low;
}
```

```java
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
```

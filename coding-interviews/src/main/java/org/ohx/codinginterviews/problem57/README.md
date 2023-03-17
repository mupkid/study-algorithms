# 面试题57. 和为s的两个数字

[力扣](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof)

同[力扣167](../../../../../../../../leetcode/src/main/java/org/ohx/leetcode/problem167)

标签：`双指针` `二分`

## 1 双指针

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
```

如果数字过大时，加法会溢出。

## 2 二分

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                if (m == nums.length - 1 || nums[m + 1] >= target) {
                    l = m;
                    break;
                }
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        while (l > 0) {
            int index = binarySearch(nums, target - nums[l]);
            if (index != -1) {
                return new int[]{nums[index], nums[l]};
            }
            l--;
        }
        return null;

    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
```

# [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/description/)

## 思路
1. 因为要求是原数组的连续子数组，所以不能改变数组元素的顺序
2. 因为元素包含正负数，所以不能通过和大小判断取不取下一个数，因此不能使用滑动数组，这也是和 [209 题](../problem209/README.md) 不同的地方。滑动数组需要满足**单调性**。
3. 前缀和是专门用来算子数组和的一种方法

## 暴力
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
```

## 前缀和 + 哈希
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1);
        for (int sum : s) {
            ans += cnt.getOrDefault(sum - k, 0);
            cnt.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
```
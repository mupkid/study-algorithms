# [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)

给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

## 思路

考虑用堆。

## 堆

## 桶排序
```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计每个元素的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }
        int maxCnt = Collections.max(cnt.values());

        // 第二步：把出现次数相同的元素，放到同一个桶中
        List<Integer>[] buckets = new ArrayList[maxCnt + 1];
        Arrays.setAll(buckets, i -> new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        // 第三步：倒序遍历 buckets，把出现次数前 k 大的元素加入答案
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxCnt; i >= 0 && j < k; i--) {
            for (int x : buckets[i]) {
                ans[j++] = x;
            }
        }
        return ans;
    }
}
```
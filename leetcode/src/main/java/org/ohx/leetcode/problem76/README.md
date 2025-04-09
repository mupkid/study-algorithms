# [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/description/)

## 思路
这道题雷同 [209 题](../problem209/README.md)，都是找到符合条件下最小的子数组。 使用滑动窗口，滑动右边界直到窗口内的元素满足条件，然后滑动左边界直到窗口内的元素不满足条件。

关键的问题是，如何更迅速地判断窗口内的元素是否满足条件？题目要求时间复杂度为 O(m + n)，使用滑动窗口后时间复杂度就是 O(m + n)，那么如何设计判断的算法？

## 滑动窗口

```java
class Solution {
    public String minWindow(String s, String t) {
        char[] charS = s.toCharArray();
        int m = charS.length;
        // 记录答案子串的下标
        int ansLeft = -1, ansRight = m;
        int[] cntS = new int[128]; // charS 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        // 滑动窗口
        int left = 0;
        for (int right = 0; right < m; right++) {
            // 右边字母移入子串
            cntS[charS[right]]++;
            while (isCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    // 比记录的更短，记录左右端点
                    ansLeft = left;
                    ansRight = right;
                }
                // 左边字母移出子串
                cntS[charS[left]]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
```

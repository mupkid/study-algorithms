# [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/description/)

## 思路
这道题雷同 [209 题](../problem209/README.md)，都是找到符合条件下最小的子数组。 使用滑动窗口，滑动右边界直到窗口内的元素满足条件，然后滑动左边界直到窗口内的元素不满足条件。

关键的问题是，如何更迅速地判断窗口内的元素是否满足条件？题目要求时间复杂度为 O(m + n)，使用滑动窗口后时间复杂度就是 O(m + n)，那么如何设计判断的算法？

## 滑动窗口

```java
class Solution {
    public String minWindow(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[s[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[s[left]]--; // 左端点字母移出子串
                left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
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
package org.ohx.leetcode.problem76;

public class Solution {
    public String minWindow(String s, String t) {
        char[] charS = s.toCharArray();
        int length = charS.length;

        // 记录答案子串的左右下标
        int ansLeft = -1, ansRight = length;

        // cnt[x] = cntT[x] - cntS[x]
        // 字符串 t 中每个字母出现的次数 - 字符串 s 中每个字母出现的次数
        // 大小字母都有，使用 128 涵盖所有的 ASCII 字符
        int[] cnt = new int[128];

        // 记录目前子串中有 less 种字母的出现次数 < t 中的字母的出现次数
        int less = 0;
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                less++;
            }
            cnt[c]++;
        }

        // 滑动窗口
        int left = 0;
        for (int right = 0; right < length; right++) {
            // 右边字母加入窗口
            cnt[charS[right]]--;
            if (cnt[charS[right]] == 0) {
                // 等于 0 时，说明这个字母出现次数和 t 一样，就可以 less - 1
                less--;
            }
            while (less == 0) {
                // 涵盖：子串现在所有字母的出现次数都是 >= t 的字母的出现次数
                if (right - left < ansRight - ansLeft) {
                    // 长度更短，更新答案
                    ansLeft = left;
                    ansRight = right;
                }
                if (cnt[charS[left]] == 0) {
                    // 左边字母移除窗口之前，检查出现次数
                    // 如果窗口内出现次数和 t 一样，那么移除窗口后，出现次数就会比 t 少
                    less++;
                }
                // 左边字母离开窗口
                cnt[charS[left]]++;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}

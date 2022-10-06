package org.ohx.leetcode.question927;

/**
 * @author mudkip
 * @date 2022/10/6
 */
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int cnt1 = 0;
        for (int num : arr) {
            if (num == 1) {
                ++cnt1;
            }
        }
        if (cnt1 % 3 != 0) {
            return new int[]{-1, -1};
        }
        if ((cnt1 /= 3) == 0) {
            // 全部都是0的情况，随便分，不越界就行;
            return new int[]{0, 2};
        }
        int suffix0 = 0;
        for (int i = arr.length - 1; i >= 0 && arr[i] == 0; i--) {
            ++suffix0;
        }
        // cnt1 为每个区间分到的1，suffix0 为每个区间的后缀0
        int a = findSplitIndex(arr, 0, cnt1, suffix0);
        if (a == -1) {
            return new int[]{-1, -1};
        }
        int b = findSplitIndex(arr, a + 1, cnt1, suffix0);
        if (b == -1) {
            return new int[]{-1, -1};
        }
        // [0, a]  [a+1, b]  [b+1, len-1]
        // 三个区间倒序遍历，只要有一个数字不同，即不符合要求
        // 有一个区间遍历完成可以了，剩余两个区间就算没遍历完，剩余的肯定是前导0
        for (int i = arr.length - 1, j = b, k = a; i > b && j > a && k >= 0; --i, --j, --k) {
            if (arr[i] != arr[j] || arr[j] != arr[k]) {
                return new int[]{-1, -1};
            }
        }
        return new int[]{a, b + 1};
    }

    int findSplitIndex(int[] arr, int from, int cnt1, int suffix0) {
        for (int i = from; ; i++) {
            if (arr[i] == 1) {
                if (--cnt1 < 0) {
                    return -1;
                }
                if (cnt1 == 0 && suffix0 == 0) {
                    return i;
                }
            } else if (cnt1 == 0 && --suffix0 == 0) {
                return i;
            }
        }
    }
}

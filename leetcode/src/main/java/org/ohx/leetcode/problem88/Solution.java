package org.ohx.leetcode.problem88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) { // 说明 nums2 还有元素没有移动
            // 如果 i < 0，要走 else 分支把 nums2 的元素合并到 nums1 中
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
}

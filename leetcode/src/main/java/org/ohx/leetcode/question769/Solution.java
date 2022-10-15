package org.ohx.leetcode.question769;

/**
 * @author mudkip
 * @date 2022/10/13
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = 0;
        // i即表达arr的下标，也表达当前范围内最大值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                result++;
            }
        }
        return result;
    }
}

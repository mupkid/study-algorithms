package org.ohx.leetcode.problem215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2022/10/7
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer topElement = minHeap.peek();
            if (nums[i] > topElement) {
                // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
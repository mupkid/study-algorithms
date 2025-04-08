package org.ohx.leetcode.problem239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            // 入元素
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);

            // 出元素
            if (i - q.getFirst() >= k) {
                q.removeFirst();
            }

            // 记答案
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}

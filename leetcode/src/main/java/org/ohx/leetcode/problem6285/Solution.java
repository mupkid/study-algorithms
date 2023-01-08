package org.ohx.leetcode.problem6285;

import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2023/1/8
 */
public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }

        long score = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = q.poll();
            score += poll;
            q.offer((int) Math.ceil(poll / 3.0));
        }

        return score;
    }
}

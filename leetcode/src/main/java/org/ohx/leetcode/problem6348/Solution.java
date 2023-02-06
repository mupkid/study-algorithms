package org.ohx.leetcode.problem6348;

import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2023/2/5
 */
public class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            queue.add(gift);
        }

        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            if (poll <= 1) {
                queue.offer(poll);
                break;
            }
            queue.offer((int) Math.sqrt(poll));
        }

        return queue.stream().mapToInt(Integer::intValue).sum();
    }
}

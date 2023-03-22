package org.ohx.codinginterviews.question40;

import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2022/8/14
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        for(int a : arr) {
            queue.offer(a);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}

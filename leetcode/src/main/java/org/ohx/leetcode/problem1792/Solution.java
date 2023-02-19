package org.ohx.leetcode.problem1792;

import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2023/2/19
 */
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c :classes){
            queue.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] c = queue.poll();
            queue.offer(new int[]{c[0] + 1, c[1] + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] c = queue.poll();
            res += 1.0 * c[0] / c[1];
        }

        return res / classes.length;
    }
}

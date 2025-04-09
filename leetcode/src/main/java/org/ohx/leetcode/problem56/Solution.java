package org.ohx.leetcode.problem56;

import java.util.*;

/**
 * @author mudkip
 * @since 2022-10-6
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int size = ans.size();
            if (size > 0 && interval[0] <= ans.get(size - 1)[1]) {
                // 可以合并
                ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], interval[1]);
            } else {
                // 不可以合并
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

package org.ohx.leetcode.question56;

import java.util.BitSet;

/**
 * @author mudkip
 * @date 2022/10/6
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            int temp = interval[1] * 2 + 1;
            bitSet.set(interval[0] * 2, temp, true);
            max = Math.max(temp, max);
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        System.arraycopy(intervals, 0, ret, 0, count);

        return ret;
    }
}

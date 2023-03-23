package org.ohx.leetcode.problem1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mudkip
 * @date 2023/3/23
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            res.add(isDifferentialSequence(nums, l[i], r[i]));
        }
        return res;
    }

    private Boolean isDifferentialSequence(int[] nums, int l, int r) {
        if (r - l < 2) {
            return Boolean.TRUE;
        }
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(temp);
        int difference = temp[1] - temp[0];
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i] + difference != temp[i + 1]) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}

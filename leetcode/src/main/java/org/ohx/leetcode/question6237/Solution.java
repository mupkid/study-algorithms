package org.ohx.leetcode.question6237;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mudkip
 * @date 2022/11/12
 */
public class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            set.add((nums[i] + nums[j]) / 2.0);
        }
        return set.size();
    }
}

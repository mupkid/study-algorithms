package org.ohx.leetcode.problem6355;

/**
 * @author mudkip
 * @date 2023/2/12
 */
public class Solution6355 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = nums[i] + nums[j];
                if (res >= lower && res <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}

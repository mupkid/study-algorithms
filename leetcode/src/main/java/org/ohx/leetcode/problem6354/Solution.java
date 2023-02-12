package org.ohx.leetcode.problem6354;

/**
 * @author mudkip
 * @date 2023/2/12
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i == j) {
                ans += nums[i];
            } else {
                ans += Integer.parseInt(nums[i] + "" + nums[j]);
            }
        }

        return ans;
    }
}

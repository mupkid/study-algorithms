package org.ohx.leetcode.problem6369;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2023/2/26
 */
public class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int right = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            answer[i] = Math.abs(left - right);
            left += nums[i];
        }
        return answer;
    }
}

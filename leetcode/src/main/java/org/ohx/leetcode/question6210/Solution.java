package org.ohx.leetcode.question6210;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/10/15
 */
public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        while (true) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 || nums[i - 1] >= nums[i] || nums[i - 1] + 1 > max) {
                    continue;
                }
                if (nums[i] == max) {
                    ++nums[i - 1];
                    --nums[i];
                    --max;
                }
            }
            int newMax = Arrays.stream(nums).max().getAsInt();
            if (max == newMax) {
                break;
            } else {
                max = newMax;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeArrayValue(new int[]{4, 7, 2, 2, 9, 19, 16, 0, 3, 15}));
    }
}

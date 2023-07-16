package org.ohx.leetcode.problem6889;

/**
 * @author mudkip
 * @date 2023/7/16
 */
public class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sqrtn = (int) Math.sqrt(n);
        int sum = 0;
        for (int i = 1; i <= sqrtn; i++) {
            if (n % i == 0) {
                sum += Math.pow(nums[i - 1], 2);
                if (n / i != i) {
                    sum += Math.pow(nums[n / i - 1], 2);
                }
            }
        }
        return sum;
    }
}

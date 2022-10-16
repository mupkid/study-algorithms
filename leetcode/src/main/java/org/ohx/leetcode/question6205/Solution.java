package org.ohx.leetcode.question6205;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mudkip
 * @date 2022/10/16
 */
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
            set.add(Integer.valueOf(String.valueOf(new StringBuilder().append(num).reverse())));
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
    }
}

package org.ohx.leetcode.problem6917;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2023/7/30
 */
public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(i -> i >= target).count();
    }
}

package org.ohx.leetcode.question217;

import java.util.stream.IntStream;

/**
 * @author mudkip
 * @date 2022/10/30
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}

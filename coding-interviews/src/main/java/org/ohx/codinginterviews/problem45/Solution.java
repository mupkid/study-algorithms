package org.ohx.codinginterviews.problem45;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2023/3/20
 */
public class Solution {
    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1)).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }
}

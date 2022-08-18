package org.ohx.leetcode.question14;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/8/18
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String min = strs[0];
        String max = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();
        int length = Math.min(min.length(), max.length());
        for (int i = 0; i < length; i++) {
            if (min.charAt(i) == max.charAt(i)) {
                sb.append(min.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}

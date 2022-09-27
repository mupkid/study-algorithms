package org.ohx.crackcodeinterview.question1;

/**
 * @author mudkip
 * @date 2022/9/27
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int total = 0 ;
        int[] counts = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            if (++counts[s1.charAt(i)] == 1) {
                ++total;
            }
            if (--counts[s2.charAt(i)] == 0) {
                --total;
            }
        }

        return total == 0;
    }
}

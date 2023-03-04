package org.ohx.crackcodeinterview.problem0109;

/**
 * @author mudkip
 * @date 2022/9/29
 */
public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }
}

package org.ohx.leetcode.problem344;

/**
 * @author mudkip
 * @date 2023/3/14
 */
public class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}

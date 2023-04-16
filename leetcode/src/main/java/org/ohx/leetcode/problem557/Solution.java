package org.ohx.leetcode.problem557;

/**
 * @author mudkip
 * @date 2023/4/16
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word)).append(' ');
        }
        return sb.substring(0, sb.length() - 1);
    }

    public char[] reverse(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return chars;
    }
}

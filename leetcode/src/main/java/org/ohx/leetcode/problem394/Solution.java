package org.ohx.leetcode.problem394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int num = 0;
        Deque<Integer> stackNum = new ArrayDeque<>();
        Deque<String> stackPre = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 括号前的数字入栈
                stackNum.push(num);
                // 括号前的字符串入栈
                stackPre.push(ans.toString());
                num = 0;
                ans = new StringBuilder();
            } else if (c == ']') {
                Integer multi = stackNum.pop();
                String pre = stackPre.pop();
                ans = new StringBuilder(pre + String.valueOf(ans).repeat(Math.max(0, multi)));
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

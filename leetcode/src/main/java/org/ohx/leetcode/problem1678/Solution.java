package org.ohx.leetcode.problem1678;

/**
 * @author mudkip
 * @date 2022/11/6
 */
public class Solution {
    public String interpret(String command) {
        // return command.replace("()","o").replace("(al)","al");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                res.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                } else {
                    res.append("al");
                }
            }
        }
        return res.toString();
    }
}

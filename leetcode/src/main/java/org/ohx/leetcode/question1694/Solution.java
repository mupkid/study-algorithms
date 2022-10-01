package org.ohx.leetcode.question1694;

/**
 * @author mudkip
 * @date 2022/10/1
 */
public class Solution {
    public String reformatNumber(String number) {
        number = number.replace(" ", "");
        number = number.replace("-", "");
        number = number.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        number = number.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3");
        return number;
    }
}

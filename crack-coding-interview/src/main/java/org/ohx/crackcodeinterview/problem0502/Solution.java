package org.ohx.crackcodeinterview.problem0502;

/**
 * @author mudkip
 * @date 2023/3/2
 */
public class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
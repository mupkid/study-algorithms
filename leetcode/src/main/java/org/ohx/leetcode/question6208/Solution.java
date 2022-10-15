package org.ohx.leetcode.question6208;

/**
 * @author mudkip
 * @date 2022/10/15
 */
public class Solution {
    public int countTime(String time) {
        String[] strings = time.split(":");
        String hour = strings[0];
        String second = strings[1];
        if ("??".equals(hour) && "??".equals(second)) {
            return 1440;
        }

        int result = 1;
        if ("??".equals(second)) {
            result *= 60;
        } else if ('?' == second.charAt(0)) {
            result *= 6;
        } else if ('?' == second.charAt(1)) {
            result *= 10;
        }

        if ("??".equals(hour)) {
            result *= 24;
        } else if ('?' == hour.charAt(0)) {
            if ('4' <= hour.charAt(1) && '9' >= hour.charAt(1)) {
                result *= 2;
            } else {
                result *= 3;
            }
        } else if ('?' == hour.charAt(1)) {
            if ('0' <= hour.charAt(0) && '1' >= hour.charAt(0)) {
                result *= 10;
            } else {
                result *= 4;
            }
        }

        return result;
    }
}

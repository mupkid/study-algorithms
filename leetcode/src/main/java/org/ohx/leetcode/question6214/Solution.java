package org.ohx.leetcode.question6214;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mudkip
 * @date 2022/10/23
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start1 = LocalTime.parse(event1[0], formatter);
        LocalTime end1 = LocalTime.parse(event1[1], formatter);

        LocalTime start2 = LocalTime.parse(event2[0], formatter);
        LocalTime end2 = LocalTime.parse(event2[1], formatter);

        return !(end1.isBefore(start2) || end2.isBefore(start1));
    }
}

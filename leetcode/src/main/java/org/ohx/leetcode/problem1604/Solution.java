package org.ohx.leetcode.problem1604;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mudkip
 * @date 2023/2/7
 */
public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>(keyName.length);
        for (int i = 0; i < keyName.length; i++) {
            map.computeIfAbsent(keyName[i], s -> new ArrayList<>()).add(keyTime[i]);
        }
        return map.entrySet().stream().filter((e) -> isUseThreeTimes(e.getValue())).map(Map.Entry::getKey)
                .distinct().sorted().collect(Collectors.toList());
    }

    private boolean isUseThreeTimes(List<String> times) {
        Collections.sort(times);
        for (int i = 2; i < times.size(); i++) {
            int time1 = toMinutes(times.get(i));
            int time2 = toMinutes(times.get(i - 2));
            if (time1 - time2 <= 60) {
                return true;
            }
        }
        return false;
    }

    private int toMinutes(String time) {
        int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return hour * 60 + minute;
    }
}

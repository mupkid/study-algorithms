package org.ohx.leetcode.problem6921;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mudkip
 * @date 2023/7/23
 */
public class Solution {
    Map<Character, String> map = Map.of(
            '.', "\\.",
            '$', "\\$",
            '|', "\\|",
            '*', "\\*"
    );

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String[] splits = word.split(map.getOrDefault(separator, String.valueOf(separator)));
            for (String split : splits) {
                if (split != null && !"".equals(split)) {
                    result.add(split);
                }
            }
        }
        return result;
    }
}

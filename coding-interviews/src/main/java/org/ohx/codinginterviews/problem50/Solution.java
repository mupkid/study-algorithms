package org.ohx.codinginterviews.problem50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mudkip
 * @date 2023/3/12
 */
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
//        for (char c : sc) {
//            if (dic.get(c)) {
//                return c;
//            }
//        }
        return dic.entrySet().stream().filter(Map.Entry::getValue).findFirst().map(Map.Entry::getKey).orElse(' ');
    }
}

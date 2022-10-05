package org.ohx.leetcode.question811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mudkip
 * @date 2022/10/5
 */
class Solution {
    public List<String> subdomainVisits(String[] ss) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : ss) {
            int n = s.length(), idx = 0;
            while (idx < n && s.charAt(idx) != ' ') {
                idx++;
            }
            int cnt = Integer.parseInt(s.substring(0, idx));
            int start = idx + 1;
            idx = n - 1;
            while (idx >= start) {
                while (idx >= start && s.charAt(idx) != '.') {
                    idx--;
                }
                String cur = s.substring(idx + 1);
                map.put(cur, map.getOrDefault(cur, 0) + cnt);
                idx--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}
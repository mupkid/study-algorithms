package org.ohx.leetcode.problem438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]--;
            while (cnt[c] < 0) {
                cnt[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }
}

package org.ohx.leetcode.problem100095;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> nums = new ArrayList<>(words.size());
        List<Integer> result = new ArrayList<>(words.size());
        int i = 0, j = 0;
        int count = 0;
        for(String word : words) {
            if ("prev".equals(word)) {
                count++;
                if (nums.isEmpty() || count > nums.size()) {
                    result.add(-1);
                } else {
                    result.add(nums.get(nums.size() - count));
                }
            } else {
                count = 0;
                nums.add(Integer.valueOf(word));
            }
        }
        return result;
    }
}

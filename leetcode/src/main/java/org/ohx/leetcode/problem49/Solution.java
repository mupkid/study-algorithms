package org.ohx.leetcode.problem49;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> Arrays.toString(s.codePoints().sorted().toArray()))).values());
    }
}

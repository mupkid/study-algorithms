package org.ohx.leetcode.question1441;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mudkip
 * @date 2022/10/15
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <= n; j++) {
            result.add("Push");
            if (j == target[i]) {
                i++;
                if (i >= target.length) {
                    break;
                }
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}

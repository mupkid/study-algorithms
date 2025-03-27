package org.ohx.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (pos.containsKey(diff)) {
                return new int[]{pos.get(diff), i};
            }
            pos.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

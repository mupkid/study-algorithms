package org.ohx.leetcode.problem560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>(nums.length + 1);
        count.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += count.getOrDefault(sum - k, 0);
            count.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}

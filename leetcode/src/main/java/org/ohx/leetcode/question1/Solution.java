package org.ohx.leetcode.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author mudkip
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int partnerNumber = target - nums[i];
            if (map.containsKey(partnerNumber)) {
                return new int[]{map.get(partnerNumber), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

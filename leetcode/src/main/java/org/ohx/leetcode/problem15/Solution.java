package org.ohx.leetcode.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                // 如果当前数字加上后面的两个数字都大于0，则后面的数字肯定也大于0，直接返回结果
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 如果当前数字与前一个数字相等，则跳过
                continue;
            }
            if (nums[i] + nums[length - 2] + nums[length - 1] < 0) {
                // 如果当前数字加上最大的两个数字都小于0，则跳过
                continue;
            }

            int l = i + 1, r = length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < -nums[i]) {
                    l++;
                } else if (sum > -nums[i]) {
                    r--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 符合结果后，两个指针都需要移动，同时跳过重复的数字
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }
        }
        return ans;
    }
}

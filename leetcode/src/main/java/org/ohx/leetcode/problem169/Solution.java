package org.ohx.leetcode.problem169;

/**
 * 169：多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于（n/2）的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author mudkip
 * @date 2022/4/21 22:00
 */
public class Solution {
    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else if (num == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}

package org.ohx.leetcode.problem6362;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mudkip
 * @date 2023/2/19
 */
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>(nums1.length + nums2.length);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i++]);
            } else if (nums1[i][0] > nums2[j][0]) {
                list.add(nums2[j++]);
            } else {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            list.add(nums1[i++]);
        }
        while (j < nums2.length) {
            list.add(nums2[j++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}

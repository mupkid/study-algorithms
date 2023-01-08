package org.ohx.leetcode.question1710;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/11/15
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);
        int result = 0;
        int s = truckSize;
        for (int[] boxType : boxTypes) {
            if (s > boxType[0]) {
                s -= boxType[0];
                result += boxType[0] * boxType[1];
            } else {
                result += s * boxType[1];
                return result;
            }
        }
        return result;
    }

//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);
//        int result = 0;
//        for (int i = 0, cnt = truckSize; i < boxTypes.length && cnt > 0; i++) {
//            int min = Math.min(boxTypes[i][0], cnt);
//            cnt -= min;
//            result += min * boxTypes[i][1];
//        }
//        return result;
//    }
}

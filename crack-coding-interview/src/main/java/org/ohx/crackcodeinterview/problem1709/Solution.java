package org.ohx.crackcodeinterview.problem1709;

/**
 * @author mudkip
 * @date 2022/9/29
 */
public class Solution {
    public int getKthMagicNumber(int k) {
        int[] result = new int[k];
        result[0] = 1;
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            result[i] = resultN;
        }
        return result[k - 1];
    }
}

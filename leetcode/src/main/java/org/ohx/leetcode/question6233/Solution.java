package org.ohx.leetcode.question6233;

/**
 * @author mudkip
 * @date 2022/11/13
 */
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}

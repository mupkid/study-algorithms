package org.ohx.leetcode.problem6287;

import java.math.BigDecimal;

/**
 * @author mudkip
 * @date 2023/1/7
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        BigDecimal volume = new BigDecimal(length).multiply(BigDecimal.valueOf(width)).multiply(BigDecimal.valueOf(height));

        if (length >= 10000 || width >= 10000 || height >= 10000 || volume.compareTo(BigDecimal.valueOf(Math.pow(10, 9))) >= 0) {
            isBulky = true;
        }
        if (mass >= 100) {
            isHeavy = true;
        }

        if (isBulky && isHeavy) {
            return "Both";
        }
        if (isBulky) {
            return "Bulky";
        }
        if (isHeavy) {
            return "Heavy";
        }
        return "Neither";
    }
}

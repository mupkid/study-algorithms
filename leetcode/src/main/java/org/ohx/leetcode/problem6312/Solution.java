package org.ohx.leetcode.problem6312;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author mudkip
 * @date 2023/3/4
 */
class Solution {
    public int splitNum(int num) {
        int num1 = 0;
        int num2 = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        list.sort(Comparator.comparingInt(Integer::intValue));

        for(int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + list.get(i);
            } else {
                num2 = num2 * 10 + list.get(i);
            }
        }
        return num1 + num2;
    }
}

package org.ohx.nowcoder.huawei.armycombat;

import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2022/8/31
 */
public class ArmyCombat {
    public int armyCombat(int[] nums) {
        PriorityQueue<Integer> num = new PriorityQueue<>((a, b) -> b - a);
        for (int j : nums) {
            num.add(j);
        }

        while (num.size() > 1) {
            int max1 = num.poll();
            int max2 = num.poll();
            int minus = max1 - max2;
            if (minus > 0) {
                num.add(minus);
            }
        }

        if (num.isEmpty()) {
            return 0;
        } else {
            return num.poll();
        }
    }

    public static void main(String[] args) {
        ArmyCombat main = new ArmyCombat();
        System.out.println(main.armyCombat(new int[]{2, 7, 4, 1, 8, 1}));
    }
}

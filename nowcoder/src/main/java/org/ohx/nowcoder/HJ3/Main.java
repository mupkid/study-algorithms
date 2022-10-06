package org.ohx.nowcoder.HJ3;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author mudkip
 * @date 2022/10/6
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            // 去重+排序 就是TreeSet数据结构
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < number; i++) {
                treeSet.add(sc.nextInt());
            }
            for (Integer integer : treeSet) {
                System.out.println(integer);
            }
        }
    }
}

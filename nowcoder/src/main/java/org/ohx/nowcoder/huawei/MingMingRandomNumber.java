package org.ohx.nowcoder.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * 当没有新的输入时，说明输入结束。
 *
 */
public class MingMingRandomNumber {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int number = sc.nextInt();
            // 去重+排序 就是TreeSet数据结构
            TreeSet<Integer> treeSet = new TreeSet<>();
            for(int i = 0; i<number; i++){
                treeSet.add(sc.nextInt());
            }
            for (Integer integer : treeSet) {
                System.out.println(integer);
            }
        }
    }
}

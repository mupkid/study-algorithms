package com.example.leetcode;

import java.util.Scanner;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author mudkip
 * @date 2022/3/17 14:15
 */
public class Leetcode12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(intToRoman(sc.nextInt()));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int rest1 = num / 1000;
        for (int i = 0; i < rest1; i++) {
            sb.append("M");
        }

        num = num % 1000;
        int rest2 = num / 100;
        if (rest2 == 9) {
            sb.append("CM");
        } else if (rest2 == 4) {
            sb.append("CD");
        } else if (rest2 >= 5) {
            sb.append("D");
            for (int i = 0; i < rest2 - 5; i++) {
                sb.append("C");
            }
        } else {
            for (int i = 0; i < rest2; i++) {
                sb.append("C");
            }
        }

        num = num % 100;
        int rest3 = num / 10;
        if (rest3 == 9) {
            sb.append("XC");
        } else if (rest3 == 4) {
            sb.append("XL");
        } else if (rest3 >= 5) {
            sb.append("L");
            for (int i = 0; i < rest3 - 5; i++) {
                sb.append("X");
            }
        } else {
            for (int i = 0; i < rest3; i++) {
                sb.append("X");
            }
        }

        num = num % 10;
        if (num == 9) {
            sb.append("IX");
        } else if (num == 4) {
            sb.append("IV");
        } else if (num >= 5) {
            sb.append("V");
            for (int i = 0; i < num - 5; i++) {
                sb.append("I");
            }
        } else {
            for (int i = 0; i < num; i++) {
                sb.append("I");
            }
        }

        return sb.toString();
    }

    public static String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
            if (num <= 0) {
                break;
            }
        }

        return sb.toString();
    }

    public static String intToRoman3(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }
}

package org.ohx.nowcoder.HJ2;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * 输出输入字符串中含有该字符的个数。
 *
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().toLowerCase();
        String c = in.nextLine().toLowerCase();
        System.out.println(s.length() - s.replaceAll(c, "").length());
    }
}

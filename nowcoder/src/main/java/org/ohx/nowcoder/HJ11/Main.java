package org.ohx.nowcoder.HJ11;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(sc.next());
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}

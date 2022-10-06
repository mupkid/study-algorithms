package org.ohx.nowcoder.HJ15;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        while (number > 0) {
            count += (number % 2);
            number /= 2;
        }
        System.out.println(count);
    }
}

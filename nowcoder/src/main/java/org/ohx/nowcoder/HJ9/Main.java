package org.ohx.nowcoder.HJ9;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] a = new int[10];
        int result = 0;
        while (number > 0) {
            if (a[number % 10] == 0) {
                a[number % 10]++;
                result = result * 10 + number % 10;
            }
            number /= 10;
        }
        System.out.println(result);
    }
}

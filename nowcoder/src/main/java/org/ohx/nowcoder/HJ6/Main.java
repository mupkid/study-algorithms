package org.ohx.nowcoder.HJ6;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();

        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                number /= i;
                System.out.print(i + " ");
            }
        }
        System.out.print(number <= 1 ? "" : number + " ");
    }
}

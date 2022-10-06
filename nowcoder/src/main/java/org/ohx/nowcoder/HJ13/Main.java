package org.ohx.nowcoder.HJ13;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        for (int i = (arr.length) - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

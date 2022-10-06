package org.ohx.nowcoder.HJ5;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next().substring(2);
            System.out.println(Long.parseLong(s, 16));
        }
    }
}

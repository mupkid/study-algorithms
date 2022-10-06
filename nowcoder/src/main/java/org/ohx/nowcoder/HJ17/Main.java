package org.ohx.nowcoder.HJ17;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int x = 0, y = 0;
            String[] arr = sc.nextLine().split(";");
            for (String s : arr) {
                int a = Integer.parseInt(s.substring(1));
                switch (s.charAt(0)) {
                    case 'A':
                        x -= a;
                        break;
                    case 'D':
                        x += a;
                        break;
                    case 'W':
                        y += a;
                        break;
                    case 'S':
                        y -= a;
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
    }
}

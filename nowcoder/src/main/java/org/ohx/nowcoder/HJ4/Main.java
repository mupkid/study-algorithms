package org.ohx.nowcoder.HJ4;

import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int zerofill = 8 - s.length() % 8;
            StringBuilder stringBuilder = new StringBuilder(s);
            while (zerofill > 0 && zerofill < 8) {
                stringBuilder.append("0");
                zerofill--;
            }
            String str1 = stringBuilder.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }
}

package org.ohx.nowcoder.HJ14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> list = new ArrayList<>();
        while (--num >= 0) {
            list.add(sc.next());
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

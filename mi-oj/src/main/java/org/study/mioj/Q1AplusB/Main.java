package org.study.mioj.Q1AplusB;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNext()) {
            line = scan.nextLine().trim();
            String[] array = line.split(" ");
            long sum = 0;
            for (int i = 0; i < array.length; i++) {
                long a = Long.parseLong(array[i]);
                sum = sum + a;
            }
            System.out.println(sum);
        }
    }
}
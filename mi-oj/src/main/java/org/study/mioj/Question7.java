package org.study.mioj;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] grades = new int[n];
            for (int i = 0; i < n; i++) {
                grades[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String s = sc.next();
                switch (s) {
                    case "Q":
                        int head = sc.nextInt();
                        int last = sc.nextInt();
                        int max = grades[head - 1];
                        for (int j = head; j < last; j++) {
                            if (grades[j] > max) {
                                max = grades[j];
                            }
                        }
                        System.out.println(max);
                        break;
                    case "U":
                        int postition = sc.nextInt();
                        int grade = sc.nextInt();
                        grades[postition - 1] = grade;
                        break;
                }
            }
        }
    }
}
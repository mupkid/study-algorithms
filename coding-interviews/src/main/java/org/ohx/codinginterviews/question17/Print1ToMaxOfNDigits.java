package org.ohx.codinginterviews.question17;

import java.util.Arrays;

/**
 * 面试题17：打印1到最大的n位数
 * <p>
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 *
 * @author mudkip
 * @date 2022/5/2
 */
public class Print1ToMaxOfNDigits {
    /**
     * 方法1
     *
     * @param n
     */
    public static void printOneToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }

        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');

        while (!increment(numbers)) {
            printNumber(numbers);
        }
    }

    /**
     * 数字数组加法，每次加1
     *
     * @param numbers
     * @return
     */
    private static boolean increment(char[] numbers) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int length = numbers.length;
        for (int i = length - 1; i >= 0; i--) {
            int nSum = numbers[i] - '0' + nTakeOver;
            if (i == length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    numbers[i] = (char) ('0' + nSum);
                }
            } else {
                numbers[i] = (char) ('0' + nSum);
                break;
            }
        }

        return isOverflow;
    }

    /**
     * 方法2
     *
     * @param n
     */
    public static void printOneToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }

        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');

        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            printOneToMaxOfNDigits2Recursively(numbers, n, 0);
        }
    }

    private static void printOneToMaxOfNDigits2Recursively(char[] numbers, int length, int index) {
        if (index == length - 1) {
            printNumber(numbers);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) (i + '0');
            printOneToMaxOfNDigits2Recursively(numbers, length, index + 1);
        }
    }

    /**
     * 打印数组数字
     *
     * @param numbers
     */
    private static void printNumber(char[] numbers) {
        boolean isBeginning0 = true;
        for (char number : numbers) {
            if (isBeginning0 && number != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.printf("%c", number);
            }
        }
        System.out.println();
    }
}

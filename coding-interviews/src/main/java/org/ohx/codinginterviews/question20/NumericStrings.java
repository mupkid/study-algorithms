package org.ohx.codinginterviews.question20;

import java.util.Objects;

/**
 * 面试题20：表示数值的字符串
 * <p>
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，
 * 但“12e”、“1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 *
 * @author mudkip
 * @date 2022/6/25
 */
public class NumericStrings {
    private static int index = 0;

    /**
     * 书中的实现。
     * 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是整数（可以有正负号，也可以没有），而B是一个无符号整数.
     * 需要一个全局变量记录下标位置。
     *
     * @param str 字符串
     * @return 是否表示数值的字符串
     */
    public static boolean isNumeric(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return false;
        }
        str = str.trim();
        if (str.length() < index) {
            return false;
        }

        // 判断前面的字符是否是有符号的整数
        boolean numeric = scanInteger(str);
        // 如果有小数点
        if (index < str.length() && '.' == str.charAt(index)) {
            index++;
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (index < str.length() && ('e' == str.charAt(index) || 'E' == str.charAt(index))) {
            index++;
            numeric = numeric && scanInteger(str);
        }

        return numeric && (index == str.length());
    }

    private static boolean scanInteger(String str) {
        if (index < str.length() && ('+' == str.charAt(index) || '-' == str.charAt(index))) {
            ++index;
        }
        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(String str) {
        int temp = index;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            ++index;
        }
        return index > temp;
    }
}

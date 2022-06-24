package org.ohx.codinginterviews.question19;

/**
 * 面试题19：正则表达式匹配
 * <p>
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）
 * 。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * <p>
 * 牛客网版本
 * 数据范围:
 * 1.str 只包含从 a-z 的小写字母。
 * 2.pattern 只包含从 a-z 的小写字母以及字符，和 *，无连续的 '*'。
 * 3.0 ≤ str.length ≤ 26
 * 4.0 ≤ pattern.length ≤ 26
 *
 * @author mudkip
 * @since 2022/5/4
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str     string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match(String str, String pattern) {
        int n1 = str.length();
        int n2 = pattern.length();
        // dp[i][j]表示str前i个字符和pattern前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        // 遍历str每个长度
        for (int i = 0; i <= n1; i++) {
            // 遍历pattern每个长度
            for (int j = 0; j <= n2; j++) {
                // 空正则的情况
                if (j == 0) {
                    dp[i][j] = (i == 0);
                    // 非空的情况下 星号、点号、字符
                } else {
                    if (pattern.charAt(j - 1) != '*') {
                        // 当前字符不为*，用.去匹配或者字符直接相同
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 碰到*
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        // 若是前一位为.或者前一位可以与这个数字匹配
                        if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n1][n2];
    }
}

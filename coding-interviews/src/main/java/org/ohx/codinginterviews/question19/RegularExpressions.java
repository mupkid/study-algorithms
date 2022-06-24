package org.ohx.codinginterviews.question19;

/**
 * 面试题19：正则表达式匹配
 * <p>
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）
 * 。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 *
 * @author mudkip
 * @date 2022/5/4
 */
public class RegularExpressions {
    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private static boolean matchCore(String str, int strIndex, String pattern, int patternIndex) {
        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        }
        // 模式串比文本串先到末尾，肯定没有匹配成功
        if (strIndex < str.length() && patternIndex == pattern.length()) {
            return false;
        }

        // 剩下两种情况：1、模式和文本都没有到结尾；2、文本到了结尾而模板还没有到结尾
        // 第2个字符是*
        if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {
            if (pattern.charAt(patternIndex) == str.charAt(strIndex) || pattern.charAt(patternIndex) == '.') {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex)
                        || matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if ((strIndex < str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex))
                || (strIndex < str.length() && pattern.charAt(patternIndex) == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }
}

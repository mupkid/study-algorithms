package org.ohx.leetcode.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testEmptyString() {
        Solution solution = new Solution();
        assertEquals(0, solution.lengthOfLongestSubstring(""));
        // 验证空字符串返回0
    }

    @Test
    public void testSingleCharacter() {
        Solution solution = new Solution();
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
        // 验证单字符返回1
    }

    @Test
    public void testAllSameChars() {
        Solution solution = new Solution();
        assertEquals(1, solution.lengthOfLongestSubstring("aaaa"));
        // 验证全重复字符返回1
    }

    @Test
    public void testMiddleRepeat() {
        Solution solution = new Solution();
        assertEquals(2, solution.lengthOfLongestSubstring("abba"));
        // 验证中间重复时窗口收缩逻辑
    }

    @Test
    public void testNormalCase() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        // 验证正常情况下的最长子串长度
    }

    @Test
    public void testRepeatingThenNewChars() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        // 验证窗口重置后的新子串
    }
}

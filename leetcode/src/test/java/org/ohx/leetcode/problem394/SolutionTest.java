package org.ohx.leetcode.problem394;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testSimpleDecode() {
        Solution solution = new Solution();
        assertEquals("aaa", solution.decodeString("3[a]"));
    }

    @Test
    public void testNestedDecode() {
        Solution solution = new Solution();
        assertEquals("abcccabccc", solution.decodeString("2[ab3[c]]"));
    }

    @Test
    public void testMultiLayerDecode() {
        Solution solution = new Solution();
        assertEquals("abbabbabb", solution.decodeString("3[a2[b]]"));
    }

    @Test
    public void testLargeNumber() {
        Solution solution = new Solution();
        String expected = "abc".repeat(12);
        assertEquals(expected, solution.decodeString("12[abc]"));
    }

    @Test
    public void testMixedCharacters() {
        Solution solution = new Solution();
        assertEquals("acdcdcdcef", solution.decodeString("a3[cd]ef"));
    }

    @Test
    public void testNoDecode() {
        Solution solution = new Solution();
        assertEquals("abc", solution.decodeString("abc"));
    }

    @Test
    public void testZeroNumber() {
        Solution solution = new Solution();
        assertEquals("", solution.decodeString("0[abc]"));
    }
}

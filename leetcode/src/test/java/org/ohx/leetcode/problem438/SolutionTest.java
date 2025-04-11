package org.ohx.leetcode.problem438;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testNormalCase() {
        List<Integer> result = solution.findAnagrams("cbaebabacd", "abc");
        assertEquals(List.of(0, 6), result);
    }

    @Test
    void testPLongerThanS() {
        List<Integer> result = solution.findAnagrams("ab", "abcd");
        assertTrue(result.isEmpty());
    }

    @Test
    void testEmptyStrings() {
        List<Integer> result1 = solution.findAnagrams("", "abc");
        assertTrue(result1.isEmpty());
        List<Integer> result2 = solution.findAnagrams("abc", "");
        assertTrue(result2.isEmpty());
    }

    @Test
    void testExactMatch() {
        List<Integer> result = solution.findAnagrams("abc", "abc");
        assertEquals(List.of(0), result);
    }

    @Test
    void testWindowShrink() {
        List<Integer> result = solution.findAnagrams("abacb", "abc");
        assertEquals(List.of(1, 3), result);
    }

    @Test
    void testMultipleMatches() {
        List<Integer> result = solution.findAnagrams("abab", "ab");
        assertEquals(List.of(0, 1, 2), result);
    }

    @Test
    void testNoMatch() {
        List<Integer> result = solution.findAnagrams("aaaa", "bba");
        assertTrue(result.isEmpty());
    }
}

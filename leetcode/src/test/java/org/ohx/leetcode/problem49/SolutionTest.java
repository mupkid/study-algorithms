package org.ohx.leetcode.problem49;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testEmptyInput() {
        String[] strs = {};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertTrue(result.isEmpty(), "空输入应返回空列表");
    }

    @Test
    void testSingleElement() {
        String[] strs = {"abc"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size(), "单元素应生成一个列表");
        assertEquals(Arrays.asList("abc"), result.get(0), "元素应正确放入列表");
    }

    @Test
    void testMultipleAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(3, result.size(), "应分组为3个列表");
        // 验证每个分组的大小（示例数据具体分组可能顺序不定）
        assertTrue(result.stream().anyMatch(list -> list.size() == 2), "存在2元素分组");
        assertTrue(result.stream().anyMatch(list -> list.size() == 3), "存在3元素分组");
    }

    @Test
    void testEmptyStrings() {
        String[] strs = {"", ""};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size(), "空字符串应分到同一组");
        assertEquals(2, result.get(0).size(), "包含两个空字符串");
    }

    @Test
    void testCaseSensitive() {
        String[] strs = {"Abc", "aBc"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(2, result.size(), "大小写不同应分到不同组");
    }

    @Test
    void testSpecialCharacters() {
        String[] strs = {"a#", "#a"};
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(1, result.size(), "特殊字符按编码排序后分组");
    }
}

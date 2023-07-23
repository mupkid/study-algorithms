package org.ohx.leetcode.problem6921;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author mudkip
 * @date 2023/7/23
 */
class SolutionTest {

    @Test
    void splitWordsBySeparator() {
        Solution solution = new Solution();
        System.out.println(solution.splitWordsBySeparator(List.of("one.two.three", "four.five", "six"), '.'));
    }
}

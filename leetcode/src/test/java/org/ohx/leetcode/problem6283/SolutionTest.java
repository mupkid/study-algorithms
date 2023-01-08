package org.ohx.leetcode.problem6283;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/1/8
 */
class SolutionTest {

    @Test
    void maximumCount() {
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }
}

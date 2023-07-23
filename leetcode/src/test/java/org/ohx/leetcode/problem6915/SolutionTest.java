package org.ohx.leetcode.problem6915;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/7/23
 */
class SolutionTest {
    @Test
    void maxArrayValue() {
        Solution solution = new Solution();
        Assertions.assertEquals(21, solution.maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        Assertions.assertEquals(11, solution.maxArrayValue(new int[]{5, 3, 3}));
        Assertions.assertEquals(6, solution.maxArrayValue(new int[]{1, 1, 1, 1, 1, 1}));
        Assertions.assertEquals(5, solution.maxArrayValue(new int[]{5, 4, 3, 2, 1}));
    }
}

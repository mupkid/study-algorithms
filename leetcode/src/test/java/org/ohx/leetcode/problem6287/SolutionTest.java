package org.ohx.leetcode.problem6287;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/1/7
 */
class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertEquals("Both", solution.categorizeBox(2909, 3968, 3272, 727));
    }
}

package org.ohx.leetcode.problem6285;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/1/8
 */
class SolutionTest {

    @Test
    void maxKelements() {
        Solution solution = new Solution();

        Assertions.assertEquals(50, solution.maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        Assertions.assertEquals(17, solution.maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
        Assertions.assertEquals(2476180565L, solution.maxKelements(new int[]{672579538, 806947365, 854095676, 815137524}, 3));
    }
}

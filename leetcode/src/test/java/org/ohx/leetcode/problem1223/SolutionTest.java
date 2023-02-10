package org.ohx.leetcode.problem1223;

import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2023/2/10
 */
class SolutionTest {

    @Test
    void dieSimulator() {
        Solution solution = new Solution();
        System.out.println(solution.dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}));
    }
}

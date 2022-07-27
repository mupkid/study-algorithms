package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question29.Solution;

/**
 * @author mudkip
 * @date 2022/7/27
 */
public class Question29Test {
    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1, 2, 3, 4}}));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{}));
    }

    @Test
    public void test5() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1}, {2}, {3}, {4}}));
    }

    @Test
    public void test6() {
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}}));
    }
}

package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question4.FindInPartiallySortedMatrix;

/**
 * @author mudkip
 * @date 2022/4/17 10:33
 */
public class Question4Test {
    @Test
    public void test1() {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assertions.assertTrue(FindInPartiallySortedMatrix.find(target, array));
    }
}

package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question3.FindDuplication;

/**
 * @author mudkip
 * @date 2022/4/16 21:25
 */
public class Question3Test {
    @Test
    public void test1() {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        Assertions.assertEquals(2, FindDuplication.duplicate(numbers));
    }
}

package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question15.NumberOfOneInBinary;

/**
 * @author mudkip
 * @date 2022/4/21 23:49
 */
public class Question15Test {
    @Test
    public void test1() {
        Assertions.assertEquals(1, NumberOfOneInBinary.numberOfOne(8));
        Assertions.assertEquals(32, NumberOfOneInBinary.numberOfOne(-1));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, NumberOfOneInBinary.numberOfOne2(8));
        Assertions.assertEquals(32, NumberOfOneInBinary.numberOfOne2(-1));
    }

    @Test
    public void Test3() {
        System.out.println(3 & 1);
    }
}

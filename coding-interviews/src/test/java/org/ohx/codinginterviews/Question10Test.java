package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question10.Fibonacci;

/**
 * @author mudkip
 * @date 2022/4/10 14:58
 */
public class Question10Test {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacci1(10));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacci2(100));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

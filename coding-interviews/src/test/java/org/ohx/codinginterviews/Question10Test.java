package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question10.Fibonacci;

public class Question10Test {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci.solution1(10));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci.soulution2(100));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question21.ReorderArray;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Question21Test {
    @Test
    public void test1() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test2() {
        int[] numbers = {2, 4, 6, 1, 3, 5, 7};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test3() {
        int[] numbers = {1, 3, 5, 7, 2, 4, 6};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test4() {
        int[] numbers = {1};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test5() {
        int[] numbers = {2};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test6() {
        int[] numbers = {};
        ReorderArray.reorderOddEvent(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    @Test
    public void test7() {
        ReorderArray.reorderOddEvent(null);
    }
}

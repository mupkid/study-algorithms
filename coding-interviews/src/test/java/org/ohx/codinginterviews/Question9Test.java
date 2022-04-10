package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question9.CQueue;
import org.ohx.codinginterviews.question9.CStack;

public class Question9Test {
    /**
     * 测试用例1：往非空队列添加、删除元素
     */
    @Test
    public void test1() {
        CQueue<Integer> queue = new CQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        Assertions.assertEquals(1, queue.poll());
        queue.offer(5);
        Assertions.assertEquals(2, queue.poll());
        queue.offer(6);
        queue.offer(7);
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(4, queue.poll());
    }

    /**
     * 测试用例2：往空队列里添加、删除元素
     */
    @Test
    public void test2() {
        CQueue<Integer> queue = new CQueue<>();
        Assertions.assertNull(queue.poll());
        queue.offer(1);
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertNull(queue.poll());
    }

    /**
     * 测试用例3：连续删除元素直到队列为空
     */
    @Test
    public void test3() {
        CQueue<Integer> queue = new CQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(2, queue.poll());
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertNull(queue.poll());
    }

    /**
     * 测试用例1：往非空栈添加、删除元素
     */
    @Test
    public void test4() {
        CStack<Integer> stack = new CStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.pop());
        stack.push(5);
        Assertions.assertEquals(5, stack.pop());
    }
}

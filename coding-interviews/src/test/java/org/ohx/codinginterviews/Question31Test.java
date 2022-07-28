package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question31.StackPushPopOrder;

/**
 * @author mudkip
 * @date 2022/7/28
 */
public class Question31Test {
    @Test
    public void test1() {
        StackPushPopOrder stackPushPopOrder = new StackPushPopOrder();
        Assertions.assertTrue(stackPushPopOrder.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        Assertions.assertTrue(stackPushPopOrder.isPopOrder(new int[]{2, 1, 0}, new int[]{1, 2, 0}));
    }
}

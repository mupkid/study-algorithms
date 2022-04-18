package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.linkedlist.ListNode;
import org.ohx.codinginterviews.question6.PrintListInReversedOrder;

/**
 * @author mudkip
 * @date 2022/4/18 21:50
 */
public class Question6Test {
    @Test
    public void Test1() {
        ListNode<Integer> listNode5 = new ListNode<>(5);
        ListNode<Integer> listNode4 = new ListNode<>(4, listNode5);
        ListNode<Integer> listNode3 = new ListNode<>(3, listNode4);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode3);
        ListNode<Integer> listNode1 = new ListNode<>(1, listNode2);

        PrintListInReversedOrder.printListInReversedOrderIteratively(listNode1);
    }
}

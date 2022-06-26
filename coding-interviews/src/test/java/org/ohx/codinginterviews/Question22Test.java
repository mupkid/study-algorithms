package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.linkedlist.ListNode;
import org.ohx.algorithmscommon.linkedlist.ListUtils;
import org.ohx.codinginterviews.question22.KthNodeFromEnd;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class Question22Test {
    @Test
    public void test1() {
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node5 = new ListNode<>(5, node6);
        ListNode<Integer> node4 = new ListNode<>(4, node5);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        ListNode<Integer> node1 = new ListNode<>(1, node2);

        ListUtils.printListNode(KthNodeFromEnd.findKthToTail(node1, 3));
    }
}

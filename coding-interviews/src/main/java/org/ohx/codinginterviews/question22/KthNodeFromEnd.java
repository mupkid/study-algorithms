package org.ohx.codinginterviews.question22;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Objects;

/**
 * 面试题22：链表中倒数第k个结点
 * <p>
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author mudkip
 * @date 2022/5/7
 */
public class KthNodeFromEnd {
    public static <T> ListNode<T> findKthToTail(ListNode<T> head, int k) {
        if (Objects.isNull(head) || k <= 1) {
            return null;
        }

        ListNode<T> fast = head;
        ListNode<T> slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.getNext();
            } else {
                // 达不到k步说明链表过短，没有倒数k
                return null;
            }
        }

        // 快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}

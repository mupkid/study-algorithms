package org.ohx.codinginterviews.question23;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Objects;

/**
 * 面试题23：链表中环的入口结点
 * <p>
 * 题目：一个链表中包含环，如何找出环的入口结点？
 *
 * @author mudkip
 * @date 2022/5/8
 */
public class EntryNodeInListLoop {
    private <T> ListNode<T> meetingNode(ListNode<T> head) {
        if (Objects.isNull(head)) {
            return null;
        }

        ListNode<T> slow = head.getNext();
        if (Objects.isNull(slow)) {
            return null;
        }

        ListNode<T> fast = slow.getNext();
        while (Objects.nonNull(fast) && Objects.nonNull(slow)) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.getNext();
            fast = fast.getNext();
            if (Objects.nonNull(fast)) {
                fast = fast.getNext();
            }
        }

        return null;
    }

    public <T> ListNode<T> entryNodeOfLoop(ListNode<T> head) {
        ListNode<T> slow = meetingNode(head);
        if (Objects.isNull(slow)) {
            return null;
        }

        ListNode<T> fast = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}

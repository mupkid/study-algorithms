package org.ohx.codinginterviews.question24;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Objects;

/**
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * @author mudkip
 * @date 2022/5/8
 */
public class ReverseList {
    public <T> ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> reversedHead = null;
        ListNode<T> node = head;
        ListNode<T> prev = null;
        ListNode<T> next;
        while (Objects.nonNull(node)) {
            next = node.getNext();
            if (Objects.isNull(next)) {
                reversedHead = node;
            }
            node.setNext(prev);
            prev = node;
            node = next;
        }
        return reversedHead;
    }
}

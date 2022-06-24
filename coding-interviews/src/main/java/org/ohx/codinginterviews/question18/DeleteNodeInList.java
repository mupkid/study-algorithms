package org.ohx.codinginterviews.question18;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Objects;

/**
 * 面试题18（一）：在O(1)时间删除链表结点
 * <p>
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * @author mudkip
 * @date 2022/5/2
 */
public class DeleteNodeInList {
    public void DeleteNode(ListNode<Integer> head, ListNode<Integer> toBeDeleted) {
        if (Objects.isNull(head) || Objects.isNull(toBeDeleted)) {
            return;
        }

        ListNode<Integer> next = toBeDeleted.getNext();
        if (Objects.nonNull(next)) {
            // 要删除的节点不是尾结点，把下一个节点的内容复制到要删除的节点，然后删除下一个节点
            toBeDeleted.setValue(next.getValue());
            toBeDeleted.setNext(next.getNext());
            next.setNext(null);
        } else if (head == toBeDeleted) {
            // 链表只有一个节点，删除头节点

        } else {
            // 链表有多个节点，删除尾节点
            ListNode<Integer> temp = head;
            while (temp.getNext() != toBeDeleted) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
    }
}

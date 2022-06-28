package org.ohx.codinginterviews.question25;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Objects;

/**
 * 面试题25：合并两个排序的链表
 * <p>
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author mudkip
 * @date 2022/6/28
 */
public class MergeSortedLists {
    public ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (Objects.isNull(head1)) {
            return head2;
        } else if (Objects.isNull(head2)) {
            return head1;
        }
        
        ListNode<Integer> mergedHead = null;
        if (head1.getValue() < head2.getValue()) {
            mergedHead = head1;
            mergedHead.setNext(merge(head1.getNext(), head2));
        } else {
            mergedHead = head2;
            mergedHead.setNext(merge(head2.getNext(), head1));
        }
        return mergedHead;
    }
}

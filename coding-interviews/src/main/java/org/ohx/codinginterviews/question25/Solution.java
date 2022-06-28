package org.ohx.codinginterviews.question25;

/**
 * 牛客网版本：JZ25 合并两个排序的链表
 * <p>
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0≤n≤1000，−1000≤节点值≤1000
 * 要求：空间复杂度O(1)，时间复杂度O(n)
 *
 * @author mudkip
 * @date 2022/6/28
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode guard = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                guard.next = list1;
                list1 = list1.next;
                guard = guard.next;
            } else {
                guard.next = list2;
                list2 = list2.next;
                guard = guard.next;
            }
        }

        if (list1 != null) {
            guard.next = list1;
        }
        if (list2 != null) {
            guard.next = list2;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
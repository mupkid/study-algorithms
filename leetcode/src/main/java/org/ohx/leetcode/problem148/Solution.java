package org.ohx.leetcode.problem148;

public class Solution {
    public ListNode sortList(ListNode head) {
        int length = getListLength(head);
        ListNode dummy = new ListNode(0, head);
        for (int step = 1; step < length; step *= 2) {
            ListNode newListTail = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                // 从 cur 开始，分割出两段长为 step 的链表，头节点分别为 head1 和 head2
                ListNode head1 = cur;
                ListNode head2 = splitList(head1, step);
                cur = splitList(head2, step);

                // 合并两段长为 step 的链表
                ListNode[] merged = mergeTwoLists(head1, head2);

                // 合并后的头节点 merged[0]，插到 newListTail 之后
                newListTail.next = merged[0];
                newListTail = merged[1];
            }
        }
        return dummy.next;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 分割链表
     * 如果链表长度 <= size，返回空节点
     * 返回链表长度 > size，把链表的前 size 个节点分割出来
     *
     * @param head
     * @param size
     * @return
     */
    private ListNode splitList(ListNode head, int size) {
        ListNode cur = head;
        for (int i = 0; i < size - 1 && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null || cur.next == null) {
            return null;
        }

        ListNode nextHead = cur.next;
        cur.next = null;
        return nextHead;
    }

    // 21. 合并两个有序链表
    private ListNode[] mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 循环结束后，cur 是合并后的链表的尾节点
        return new ListNode[]{dummy.next, cur};
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
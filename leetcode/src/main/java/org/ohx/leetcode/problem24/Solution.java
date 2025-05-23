package org.ohx.leetcode.problem24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;
            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
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
package org.ohx.leetcode.problem86;

/**
 * @author mudkip
 * @date 2023/2/22
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p = dummy1;
        ListNode q = dummy2;

        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }

        p.next = dummy2.next;
        return dummy1.next;
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

package org.ohx.leetcode.problem19;

/**
 * @author mudkip
 * @date 2023/3/5
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return head;
            }
            fast = fast.next;
        }

        ListNode dummy = new ListNode(-1, head), p = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            p = p.next;
        }
        p.next = slow.next;
        slow.next = null;
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

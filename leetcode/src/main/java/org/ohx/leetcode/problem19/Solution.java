package org.ohx.leetcode.problem19;

/**
 * @author mudkip
 * @date 2023/3/5
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 要删除倒数第n个节点，要先找到倒数第n+1个节点
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }

        ListNode dummy = new ListNode(-1, head), slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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

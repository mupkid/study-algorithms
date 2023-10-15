package org.ohx.leetcode.problem6914;

/**
 * @author mudkip
 * @date 2023/8/13
 */
public class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null || head.val == 0) {
            return head;
        }
        int num = 0;
        for (ListNode p = head; p != null; p = p.next) {
            num = num * 10 + p.val;
        }
        num *= 2;

        ListNode newHead = null;
        for(int i = num; i != 0; i /= 10) {
            newHead = new ListNode(i % 10, newHead);
        }
        return newHead;
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

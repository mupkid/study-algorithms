package org.ohx.leetcode.problem234;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // 找到中间的节点
        ListNode middle = middleNode(head);
        // 翻转后半的链表
        ListNode head2 = reverseList(middle);
        for (ListNode p = head; head2 != null; p = p.next, head2 = head2.next) {
            if (p.val != head2.val) {
                return false;
            }
        }
        return true;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
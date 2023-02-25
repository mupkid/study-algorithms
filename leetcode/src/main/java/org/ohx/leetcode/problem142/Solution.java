package org.ohx.leetcode.problem142;

/**
 * @author mudkip
 * @date 2023/2/25
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                for (fast = head; slow != fast; slow = slow.next, fast = fast.next) {
                }
                return fast;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

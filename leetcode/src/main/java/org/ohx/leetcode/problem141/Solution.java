package org.ohx.leetcode.problem141;

/**
 * @author mudkip
 * @date 2023/2/25
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        for (ListNode fast = head.next.next, slow = head; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next) {
            if (fast == slow) {
                return true;
            }
        }

        return false;
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

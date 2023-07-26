package org.ohx.leetcode.problem92;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2023/7/26
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果 left = 1，相当于翻转链表前n个节点
        if (left == 1) {
            return reverseN(head, right);
        }

        // 递归往后推，直到问题退化成翻转前n个节点
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        if (n <= 1) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        int i = 0;
        while (Objects.nonNull(curr) && i < n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            head.next = curr;
            i++;
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

package org.ohx.codinginterviews.question24;

/**
 * 牛客网版本：JZ24 反转链表
 * <p>
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： 0≤n≤1000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)。
 *
 * @author mudkip
 * @date 2022/5/8
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

package org.ohx.codinginterviews.question23;

/**
 * 牛客网版本：JZ23 链表中环的入口结点
 * <p>
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * <p>
 * 数据范围： n≤10000，1<=结点值<=10000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * @author mudkip
 * @date 2022/5/8
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);
        // 没有环
        if (slow == null) {
            return null;
        }
        // 快指针回到表头
        ListNode fast = pHead;
        // 再次相遇即是环入口
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 判断链表中是否有环
     *
     * @param head 头节点
     * @return 有环，则返回环内的随机一个节点，没有环，则返回null
     */
    private ListNode hasCycle(ListNode head) {
        // 先判断链表为空的情况
        if (head == null) {
            return null;
        }
        // 快慢双指针
        ListNode fast = head;
        ListNode slow = head;
        // 如果没环快指针会先到链表尾
        while (fast != null && fast.next != null) {
            // 快指针移动两步
            fast = fast.next.next;
            // 慢指针移动一步
            slow = slow.next;
            // 相遇则有环，返回相遇的位置
            if (fast == slow) {
                return slow;
            }
        }
        // 到末尾说明没有环，返回null
        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

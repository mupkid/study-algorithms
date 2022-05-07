package org.ohx.codinginterviews.question22;

/**
 * 面试题22：链表中倒数第k个结点
 * <p>
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/5/7
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        int n = 0;
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 快指针先行k步
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // 达不到k步说明链表过短，没有倒数k
                return null;
            }
        }
        // 快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

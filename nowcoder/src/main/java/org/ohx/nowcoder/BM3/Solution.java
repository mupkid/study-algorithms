package org.ohx.nowcoder.BM3;

/**
 * @author mudkip
 * @date 2022/8/14
 */
public class Solution {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        int length = getLength(head);
        // 假头节点，用来记录链表翻转后的头节点
        ListNode dummy = new ListNode();
        // 记录每段链表头的上一个节点，用来每翻转一段后，能够指向新的头节点
        ListNode cur = dummy;
        for (int i = 0; i < length / k; i++) {
            // 在下面的循环中，每翻转一次，最后都记录着最新的头节点
            ListNode temp = null;
            ListNode next;
            // 第 i 块的链表进行翻转
            for (int j = 0; j < k; j++) {
                next = head.next;
                head.next = temp;
                temp = head;
                head = next;
            }
            cur.next = temp;
            while (cur.next != null) {
                // 一直走到翻转后的链表的末尾
                cur = cur.next;
            }
        }
        // 要翻转的块都翻转完成后，head指针指在剩余节点的头部
        cur.next = head;
        return dummy.next;
    }

    private int getLength(ListNode now) {
        int count = 0;
        while (now != null) {
            count++;
            now = now.next;
        }
        return count;
    }
}

class ListNode {
    int val;
    ListNode next = null;
}
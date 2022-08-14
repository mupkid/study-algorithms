package org.ohx.nowcoder.BM2;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/14
 */
public class Solution {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (Objects.isNull(head) || n - m < 1) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = n - m; i > 0; i--) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;
}
package org.ohx.leetcode.problem23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2023/2/22
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            while (list != null) {
                queue.offer(list);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
        }
        // 防止成环
        p.next = null;
        return dummy.next;
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

package org.ohx.codinginterviews.question18;

/**
 * 面试题18（一）：在O(1)时间删除链表节点
 * <p>
 * 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 * <p>
 * 牛客网版本
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * 1.此题对比原题有改动
 * 2.题目保证链表中节点的值互不相同
 * 3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * @author mudkip
 * @date 2022/5/2
 */
public class Solution {
    /**
     * @param head ListNode类
     * @param val  int整型
     * @return ListNode类
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 加入一个头节点
        ListNode res = new ListNode(0);
        res.next = head;
        // 前序节点
        ListNode pre = res;
        // 当前节点
        ListNode cur = head;
        // 遍历链表
        while (cur != null) {
            // 找到目标节点
            if (cur.val == val) {
                // 断开连接
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 返回去掉头节点
        return res.next;
    }


    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

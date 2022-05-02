package org.ohx.codinginterviews.question18;

/**
 * 面试题18（一）：在O(1)时间删除链表结点
 * <p>
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * <p>
 * 牛客网版本
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
        //加入一个头节点
        ListNode res = new ListNode(0);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //遍历链表
        while (cur != null) {
            //找到目标节点
            if (cur.val == val) {
                //断开连接
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        //返回去掉头节点
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

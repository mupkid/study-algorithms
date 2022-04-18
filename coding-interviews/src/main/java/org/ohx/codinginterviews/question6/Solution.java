package org.ohx.codinginterviews.question6;

import java.util.ArrayList;

/**
 * 面试题6：从尾到头打印链表
 * <p>
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/4/18 21:42
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }

        return list;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

package org.ohx.codinginterviews.question6;

import org.ohx.algorithmscommon.linkedlist.ListNode;

import java.util.Stack;

/**
 * 面试题6：从尾到头打印链表
 * <p>
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 *
 * @author mudkip
 * @date 2022/4/18 21:36
 */
public class PrintListInReversedOrder {
    public static <T> void printListInReversedOrderIteratively(ListNode<T> listNode) {
        Stack<T> stack = new Stack<>();
        ListNode<T> temp = listNode;
        while (temp != null) {
            stack.push(temp.getValue());
            temp = temp.getNext();
        }

        for (int i = stack.size(); i > 0; i--) {
            System.out.println(stack.pop());
        }

        // 正序打印栈
//        for (T value : stack) {
//            System.out.println(value);
//        }
    }
}

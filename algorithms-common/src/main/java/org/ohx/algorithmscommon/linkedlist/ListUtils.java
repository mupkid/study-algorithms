package org.ohx.algorithmscommon.linkedlist;

import java.util.Objects;

/**
 * 链表工具类
 *
 * @author mudkip
 * @date 2022/6/26
 */
public class ListUtils {
    /**
     * 打印整个链表
     *
     * @param head 链表头指针
     * @param <T> T
     */
    public static <T> void printLinkedList(ListNode<T> head) {
        ListNode<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    /**
     * 打印链表节点
     *
     * @param listNode 链表节点
     * @param <T> T
     */
    public static <T> void printListNode(ListNode<T> listNode) {
        if (Objects.isNull(listNode)) {
            return;
        }
        System.out.println(listNode.getValue());
    }
}

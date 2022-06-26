package org.ohx.algorithmscommon.linkedlist;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/6/26
 */
public class ListUtils {
    public static <T> void printLinkedList(ListNode<T> head) {
        ListNode<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public static <T> void printListNode(ListNode<T> listNode) {
        if (Objects.isNull(listNode)) {
            return;
        }
        System.out.println(listNode.getValue());
    }
}

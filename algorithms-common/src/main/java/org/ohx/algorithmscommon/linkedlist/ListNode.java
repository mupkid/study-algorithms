package org.ohx.algorithmscommon.linkedlist;

/**
 * 链表节点
 *
 * @author mudkip
 * @date 2022/4/10 16:45
 */
public class ListNode<T> {
    private T value;

    private ListNode<T> next = null;

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}

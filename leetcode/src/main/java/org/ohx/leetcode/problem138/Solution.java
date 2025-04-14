package org.ohx.leetcode.problem138;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 1. 复制新节点，查到原节点后面
        for (Node p = head; p != null; p = p.next.next) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
        }

        // 2. 遍历链表，连接新节点的random节点
        for (Node p = head; p != null; p = p.next.next) {
            p.next.random = p.random == null ? null : p.random.next;
        }

        // 分裂成两个链表
        Node newHead = new Node(-1);
        Node p = head, q = newHead;
        while (p != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        return newHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
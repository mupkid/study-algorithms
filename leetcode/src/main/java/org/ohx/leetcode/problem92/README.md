# [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)

翻转链表前N个节点（非递归）
```java
ListNode reverseN(ListNode head, int n) {
    if (n <= 1) {
       return head;
    }

    ListNode prev = null;
    ListNode curr = head;
    int i = 0;
    while (Objects.nonNull(curr) && i < n) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        head.next = curr;
        i++;
    }
    return prev;
}
```

翻转链表前N个节点（递归）
```java
ListNode reverseN(ListNode head, int n) {
    if (n <= 1 || Objects.isNull(head) || Objects.isNull(head.next)) {
        return head;
    }

    ListNode newHead = reverseN(head.next, n - 1);
    ListNode next = head.next;
    head.next = next.next;
    next.next = head;
    return newHead;
}
```

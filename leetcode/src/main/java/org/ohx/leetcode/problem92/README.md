# [92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii/)

## 思路
参考 206，找到需要反转的区间，反转再重新连接链表

## 递归
当 left = 1 时，相当于翻转链表前 right - left + 1 个节点。
那么找到需要反转的区间的第一个节点时，问题退化成把后续的链表反转前 right - left + 1 个节点。

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果 left = 1，相当于翻转链表前n个节点
        if (left == 1) {
            return reverseN(head, right);
        }

        // 递归往后推，直到问题退化成翻转前n个节点
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
```

## 头插法
从反转的区间开始，每走到一个节点，就把该节点插入到最前的位置。





翻转链表前N个节点（非递归），在 206 题的代码上稍作修改。
```java
class Solution {
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
            // 头节点连到未反转部分的头节点
            head.next = curr;
            i++;
        }
        return prev;
    }
}
```

翻转链表前N个节点（递归）
```java
class Solution {
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
}
```

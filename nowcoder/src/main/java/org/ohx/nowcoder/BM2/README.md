# [BM2 链表内指定区间反转](https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c)

> 题目：将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。

例如：

给出的链表 1->2->3->4->5，m=2，n=4

那么返回 1->4->3->2->5

数据范围： 链表长度 0 < size ≤ 1000，0 < m < n ≤ size，链表中每个节点的值满足 |val| ≤ 1000

要求：时间复杂度 O(n) ，空间复杂度 O(n)

进阶：时间复杂度 O(n)，空间复杂度 O(1)

## 1

思路：

1. 遍历链表的时候，把当前的节点直接搬到区间的最前面，就像：
    1. 1->2->3->4->5
    2. 1->3->2->4->5
    3. 1->4->3->2->5
2. 但是有可能 m=1，这时候就缺少了一个指向 head 的指针，为了保证区间链表的完整性，在整个链表前面添加一个虚拟的头节点。

```java
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (Objects.isNull(head) || n - m < 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = n - m; i > 0; i--) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}
```


# [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)

## 思路

在 [92](../problem92/README.md) 的基础上改

## 

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        // 这里和 92 题的代码是类似的
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = p0.next;
        while (n >= k) {
            n -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 因为要移动 p0，所以先记 p0.next
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }
}
```
# [138. 随机链表的复制](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

## 实现

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 复制每个节点，把新节点直接插到原节点的后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }

        // 遍历交错链表中的原链表节点
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                // 要复制的 random 是 cur.random 的下一个节点
                cur.next.random = cur.random.next;
            }
        }

        // 把交错链表分离成两个链表
        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next; // 恢复原节点的 next
            copy.next = copy.next.next; // 设置新节点的 next
        }
        cur.next = null; // 恢复原节点的 next
        return newHead;
    }
}
```
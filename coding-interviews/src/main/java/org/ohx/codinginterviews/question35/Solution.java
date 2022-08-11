package org.ohx.codinginterviews.question35;

/**
 * @author mudkip
 * @date 2022/8/7
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 第一步：遍历原始链表，开始复制
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        // 第二步：连接新链表的random节点
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 第三步：双指针，拆分链表
        RandomListNode copy = pHead.next;
        cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            next.next = next.next == null ? null : next.next.next;
            cur = cur.next;
        }
        return copy;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

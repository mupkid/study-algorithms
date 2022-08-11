package org.ohx.codinginterviews.question36;

import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author mudkip
 * @date 2022/8/11
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode head = null;
        TreeNode pre = null;
        // 标记位：第一个遍历到最左的叶子节点，就是链表头
        boolean isFirst = true;
        while (pRootOfTree != null || !s.isEmpty()) {
            // 走到最左叶子节点
            while (pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            pRootOfTree = s.pop();
            if (isFirst) {
                // 标记表头
                head = pRootOfTree;
                pre = head;
                isFirst = false;
            } else {
                // 中序遍历各个节点，连接起来
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }
        return head;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
package org.ohx.leetcode.problem114;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = new TreeNode();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre.right = node;
            node.left = null;
            pre = node;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
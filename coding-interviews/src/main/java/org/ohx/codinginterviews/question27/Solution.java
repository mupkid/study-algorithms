package org.ohx.codinginterviews.question27;

import java.util.Stack;

/**
 * 牛客网版本：JZ27 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 数据范围：二叉树的节点数 0≤n≤1000 ， 二叉树每个节点的值 0≤val≤1000
 * 要求： 空间复杂度 O(n) 。本题也有原地操作，即空间复杂度 O(1) 的解法，时间复杂度 O(n)
 *
 * @author mudkip
 * @date 2022/6/28
 */
public class Solution {
    public TreeNode Mirror(TreeNode pRoot) {
        // 空树
        if (pRoot == null) {
            return null;
        }
        // 辅助栈
        Stack<TreeNode> s = new Stack<TreeNode>();
        // 根节点先进栈
        s.push(pRoot);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            // 左右节点入栈
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
            // 交换左右
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return pRoot;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

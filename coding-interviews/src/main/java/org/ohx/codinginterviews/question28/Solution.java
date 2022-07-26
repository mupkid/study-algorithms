package org.ohx.codinginterviews.question28;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mudkip
 * @date 2022/7/26
 */
public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        // 空树为对称的
        if (pRoot == null) {
            return true;
        }
        // 辅助队列用于从两边层次遍历
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 分别从左边和右边弹出节点
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            //都为空暂时对称
            if (left == null && right == null) {
                continue;
            }
            //某一个为空或者数字不相等则不对称
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            // 从左往右加入队列
            q1.offer(left.left);
            q1.offer(left.right);
            // 从右往左加入队列
            q2.offer(right.right);
            q2.offer(right.left);
        }
        // 都检验完都是对称的
        return true;
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
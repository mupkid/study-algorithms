package org.ohx.codinginterviews.question32;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

/**
 * 牛客网版本：JZ32 从上往下打印二叉树
 * <p>
 * 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印。例如输入{8,6,10,#,#,2,1}，如以下图中的示例二叉树，则依次打印8,6,10,2,1(空节点不打印，跳过)，请你将打印的结果存放到一个数组里面，返回。
 * 数据范围:
 * 0<=节点总数<=1000
 * -1000<=节点值<=1000
 *
 * @author mudkip
 * @date 2022/7/29
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (Objects.isNull(root)) {
            return list;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.val);
            if (Objects.nonNull(node.left)) {
                q.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.add(node.right);
            }
        }

        return list;
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
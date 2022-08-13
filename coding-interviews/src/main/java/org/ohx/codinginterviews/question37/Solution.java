package org.ohx.codinginterviews.question37;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 牛客网版本：JZ37 序列化二叉树
 * <p>
 * 描述：请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。
 * <p>
 * 二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#）
 * <p>
 * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 数据范围：节点数 0n≤100，树上每个节点的值满足 0≤val≤150。
 * 要求：序列化和反序列化都是空间复杂度 O(n)，时间复杂度 O(n)
 *
 * @author mudkip
 * @date 2022/8/13
 */
public class Solution {
    /**
     * 使用层序遍历序列化
     * 每个节点用","分割，null用“#”表示，而根节点为null时，返回空字符串
     *
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.isNull(node)) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    /**
     * 对层序遍历序列化的字符串进行反序列化
     *
     * @param str
     * @return
     */
    public TreeNode Deserialize(String str) {
        if (Objects.isNull(str) || str.length() < 1) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 构建左节点
            if (!"#".equals(nodes[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            // 构建右节点
            if (!"#".equals(nodes[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
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
package org.ohx.codinginterviews.question37;

import java.util.Objects;

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
     * 序列的下标
     */
    private int index = 0;

    private void SerializeFunction(TreeNode root, StringBuilder str) {
        //如果节点为空，表示左子节点或右子节点为空，用#表示
        if (root == null) {
            str.append('#');
            return;
        }
        // 根节点
        str.append(root.val).append('!');
        // 左子树
        SerializeFunction(root.left, str);
        // 右子树
        SerializeFunction(root.right, str);
    }

    public String Serialize(TreeNode root) {
        // 处理空树
        if (root == null) {
            return "#";
        }
        StringBuilder res = new StringBuilder();
        SerializeFunction(root, res);
        // 把str转换成char
        return res.toString();
    }

    private TreeNode DeserializeFunction(String str) {
        // 到达叶节点时，构建完毕，返回继续构建父节点
        // 空节点
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        // 数字转换
        int val = 0;
        // 遇到分隔符或者结尾
        while (str.charAt(index) != '!') {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        index++;
        // 反序列化与序列化一致，都是前序
        root.left = DeserializeFunction(str);
        root.right = DeserializeFunction(str);
        return root;
    }

    public TreeNode Deserialize(String str) {
        // 空序列对应空树
        if (Objects.equals(str, "#")) {
            return null;
        }
        return DeserializeFunction(str);
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
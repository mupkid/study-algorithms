package org.ohx.codinginterviews.question26;

/**
 * 牛客网版本：JZ26 树的子结构
 * <p>
 * 描述：输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 * 假如给定A为{8,8,7,9,2,#,#,#,#,4,7}，B为{8,9,2}，2个树的结构如下，可以看出B是A的子结构
 *
 * @author mudkip
 * @date 2022/6/28
 */
public class Solution {
    private boolean recursion(TreeNode root1, TreeNode root2) {
        // 当一个节点存在另一个不存在时
        if (root1 == null && root2 != null) {
            return false;
        }
        // 两个都为空则返回
        if (root1 == null || root2 == null) {
            return true;
        }
        // 比较节点值
        if (root1.val != root2.val) {
            return false;
        }
        // 递归比较子树
        return recursion(root1.left, root2.left) && recursion(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // 空树
        if (root1 == null || root2 == null) {
            return false;
        }
        //递归比较
        boolean flag1 = recursion(root1, root2);
        //递归树1的每个节点
        boolean flag2 = HasSubtree(root1.left, root2);
        boolean flag3 = HasSubtree(root1.right, root2);
        return flag1 || flag2 || flag3;
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

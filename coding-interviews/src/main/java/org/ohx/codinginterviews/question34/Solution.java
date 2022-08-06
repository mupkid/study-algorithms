package org.ohx.codinginterviews.question34;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 牛客网版本：JZ34 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * <p>
 * 数据范围:
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= 节点值 <= 1000
 * -1000 <= expectNumber <= 1000
 *
 * @author mudkip
 * @date 2022/8/6
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        dfs(root, expectNumber);
        return ret;
    }

    private void dfs(TreeNode root, int number) {
        // 处理树为空
        if (root == null) {
            return;
        }
        // 路径更新
        path.add(root.val);
        // number更新
        number -= root.val;
        // 如果递归当前节点为叶子节点且该条路径的值已经达到了expectNumber，则更新ret
        if (root.left == null && root.right == null && number == 0) {
            ret.add(new ArrayList<>(path));
        }
        // 左右子树递归
        dfs(root.left, number);
        dfs(root.right, number);
        path.removeLast();
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
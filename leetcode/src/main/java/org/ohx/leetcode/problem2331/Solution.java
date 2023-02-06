package org.ohx.leetcode.problem2331;

/**
 * @author mudkip
 * @date 2023/2/6
 */
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.val < 2) {
            return root.val == 1;
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
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

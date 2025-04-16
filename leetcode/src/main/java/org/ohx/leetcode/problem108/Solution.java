package org.ohx.leetcode.problem108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    // 把 nums[left] 到 nums[right-1] 转成平衡二叉搜索树
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right) >>> 1;
        return new TreeNode(nums[m], dfs(nums, left, m), dfs(nums, m + 1, right));
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
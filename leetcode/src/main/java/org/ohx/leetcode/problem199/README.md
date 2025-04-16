# [199.二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/)

## 思路

可以使用层序遍历，从左到右遍历每一层，遍历到每一层的最后一个节点时，将该节点的值加入到结果数组中。

## 层序遍历

## 递归
```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) { // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }
}
```
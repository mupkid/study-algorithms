# [98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/)

## 前序遍历

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long left, long right) {
        if (root == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right
                && isValidBST(node.left, left, x)
                && isValidBST(node.right, x, right);
    }
}
```

## 中序遍历

## 后序遍历
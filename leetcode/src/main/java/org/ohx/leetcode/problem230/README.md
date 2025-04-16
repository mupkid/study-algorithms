# [230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/)]

## 思路

根据二叉搜索树的特性，使用中序遍历刚好是从小到大遍历树，因此中序遍历遍历到第 K 个节点时，就是第 K 小的节点。

## 递归写法

```java
class Solution {
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1; // 题目保证节点值非负，用 -1 表示没有找到
        }
        int leftRes = dfs(node.left);
        if (leftRes != -1) { // 答案在左子树中
            return leftRes;
        }
        if (--k == 0) { // 答案就是当前节点
            return node.val;
        }
        return dfs(node.right); // 右子树会返回答案或者 -1
    }
}
```
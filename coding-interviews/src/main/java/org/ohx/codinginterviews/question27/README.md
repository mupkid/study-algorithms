# 面试题27：二叉树的镜像

> 题目：请完成一个函数，输入一棵二叉树，该函数输出它的镜像。

[力扣](https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/)

标签：`树`

## 1 递归（原书实现）

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
```

## 2 非递归

既可以使用广度优先搜索，也可以使用深度优先搜索，那用队列或栈都没有问题。

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }
}
```

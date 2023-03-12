# 面试题28：对称的二叉树

> 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

标签：`树`

## 1 递归写法

```java
class Solution {
    public boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (Objects.isNull(pRoot1) && Objects.isNull(pRoot2)) {
            return true;
        }
        if (Objects.isNull(pRoot1) || Objects.isNull(pRoot2) || pRoot1.val != pRoot2.val) {
            return false;
        }

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
```

## 2 非递归写法

```java
class Solution {
    public boolean isSymmetrical(TreeNode root) {
        // 空树为对称的
        if (root == null) {
            return true;
        }
        
        // 辅助队列用于从两边层次遍历
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 分别从左边和右边弹出节点
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();

            //都为空暂时对称
            if (left == null && right == null) {
                continue;
            }

            //某一个为空或者数字不相等则不对称
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // 从左往右加入队列
            q1.offer(left.left);
            q1.offer(left.right);

            // 从右往左加入队列
            q2.offer(right.right);
            q2.offer(right.left);
        }
        // 都检验完都是对称的
        return true;
    }
}
```

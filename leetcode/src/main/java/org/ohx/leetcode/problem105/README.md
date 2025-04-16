# [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## 递归

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            // 空节点
            return null;
        }

        int leftSize = indexOf(inorder, preorder[0]);
        // 左子树的前序
        int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        // 右子树的前序
        int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
        // 左子树的中序
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        // 右子树的中序
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }

    /**
     * 返回根节点在中序遍历中的下标
     *
     * @param inorder
     * @param target
     * @return
     */
    private int indexOf(int[] inorder, int target) {
        for (int i = 0; ; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
    }
}
```

时间复杂度 O(n^2)
空间复杂度 O(n^2)
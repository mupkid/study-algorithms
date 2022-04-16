package org.ohx.codinginterviews.question8;

/**
 * 面试题8：二叉树的下一个结点
 * <p>
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * <p>
 * <a href="https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e">牛客网</a>版本
 *
 * @author mudkip
 * @date 2022/4/16 14:48
 */
public class Solution {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // 第一种情况：如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
        if (pNode.right != null) {
            // 如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        // 第二种情况：无右子树，且当前节点是父节点的左子树，则下一个节点就是父节点
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        // 第三种情况：无右子树，且当前节点是父节点的右子树，则一直沿着父节点追朔，直到找到某个节点是其父节点的左子树，
        // 如果存在这样的节点，那么这个节点的父节点就是我们要找的下一节点。
        if (pNode.next != null) {
            TreeLinkNode parent = pNode.next;
            while (parent.next != null && parent.next.right == parent) {
                parent = parent.next;
            }
            return parent.next;
        }
        return null;
    }

    static class TreeLinkNode {
        int val;

        /**
         * 左节点
         */
        TreeLinkNode left = null;

        /**
         * 右节点
         */
        TreeLinkNode right = null;

        /**
         * 父节点
         */
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

package org.ohx.codinginterviews.question26;

import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.Objects;

/**
 * 面试题26：树的子结构
 * <p>
 * 题目：输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *
 * @author mudkip
 * @date 2022/6/28
 */
public class SubstructureInTree {
    public static <E> boolean hasSubtree(BinaryTreeNode<E> root1, BinaryTreeNode<E> root2) {
        boolean result = false;

        if (Objects.nonNull(root1) && Objects.nonNull(root2)) {
            if (root1.getValue().equals(root2.getValue())) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.getLeftChild(), root2);
            }
            if (!result) {
                result = hasSubtree(root1.getRightChild(), root2);
            }
        }

        return result;
    }

    private static <E> boolean doesTree1HaveTree2(BinaryTreeNode<E> root1, BinaryTreeNode<E> root2) {
        if (Objects.isNull(root2)) {
            return true;
        }
        if (Objects.isNull(root1)) {
            return false;
        }
        if (!root1.getValue().equals(root2.getValue())) {
            return false;
        }
        return doesTree1HaveTree2(root1.getLeftChild(), root2.getLeftChild())
                && doesTree1HaveTree2(root1.getRightChild(), root2.getRightChild());
    }
}

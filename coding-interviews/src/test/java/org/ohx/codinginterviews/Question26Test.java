package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.tree.BinaryTreeNode;
import org.ohx.codinginterviews.question26.SubstructureInTree;

/**
 * @author mudkip
 * @date 2022/6/28
 */
public class Question26Test {
    /**
     *                   8                8
     *               /       \           / \
     *              8         7         9   2
     *            /   \
     *           9     2
     *                / \
     *               4   7
     */
    @Test
    public void Test1() {
        BinaryTreeNode<Integer> nodeA7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> nodeA6 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> nodeA5 = new BinaryTreeNode<>(2, nodeA6, nodeA7);
        BinaryTreeNode<Integer> nodeA4 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> nodeA3 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> nodeA2 = new BinaryTreeNode<>(8, nodeA4, nodeA5);
        BinaryTreeNode<Integer> nodeA1 = new BinaryTreeNode<>(8, nodeA2, nodeA3);

        BinaryTreeNode<Integer> nodeB3 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> nodeB2 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> nodeB1 = new BinaryTreeNode<>(8, nodeB2, nodeB3);

        Assertions.assertTrue(SubstructureInTree.hasSubtree(nodeA1, nodeB1));
    }
}

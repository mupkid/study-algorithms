package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.tree.BinaryTreeNode;
import org.ohx.codinginterviews.question32.PrintTreesInLines;
import org.ohx.codinginterviews.question32.PrintTreesInZigzag;

import javax.swing.tree.TreeNode;
import java.util.function.BinaryOperator;

/**
 * @author mudkip
 * @date 2022/7/29
 */
public class Question32Test {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, left, right);

        PrintTreesInLines printTreesInLines = new PrintTreesInLines();
        printTreesInLines.print(root);
    }

    @Test
    public void test3() {
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, left, right);

        PrintTreesInZigzag printTreesInZigzag = new PrintTreesInZigzag();
        printTreesInZigzag.print(root);
    }
}

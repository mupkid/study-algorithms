package org.ohx.codinginterviews.question32;

import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

/**
 * 面试题32（一）：不分行从上到下打印二叉树。
 *
 * @author mudkip
 * @date 2022/7/29
 */
public class PrintTreeFromTopToBottom {
    public <E> void printFromTopToBottom(BinaryTreeNode<E> root) {
        if (Objects.isNull(root)) {
            return;
        }

        Queue<BinaryTreeNode<E>> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<E> node = q.poll();
            System.out.println(node.getValue());
            if (Objects.nonNull(node.getLeftChild())) {
                q.add(node.getLeftChild());
            }
            if (Objects.nonNull(node.getRightChild())) {
                q.add(node.getRightChild());
            }
        }
    }
}

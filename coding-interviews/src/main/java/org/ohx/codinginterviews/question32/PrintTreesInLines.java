package org.ohx.codinginterviews.question32;

import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 面试题32（二）：分行从上到下打印二叉树
 *
 * @author mudkip
 * @date 2022/7/29
 */
public class PrintTreesInLines {
    public <E> void print(BinaryTreeNode<E> root) {
        if (Objects.isNull(root)) {
            return;
        }

        // 表示下一层的节点数
        int nextLevel = 0;
        // 表示在当前层中还没有打印的节点数
        int toBePrinted = 1;
        Queue<BinaryTreeNode<E>> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<E> node = q.poll();
            toBePrinted--;
            System.out.print(node.getValue() + " ");
            if (Objects.nonNull(node.getLeftChild())) {
                q.add(node.getLeftChild());
                nextLevel++;
            }
            if (Objects.nonNull(node.getRightChild())) {
                q.add(node.getRightChild());
                nextLevel++;
            }

            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}

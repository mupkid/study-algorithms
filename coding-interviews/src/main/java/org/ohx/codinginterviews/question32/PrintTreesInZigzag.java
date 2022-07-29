package org.ohx.codinginterviews.question32;

import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * 面试题32（三）：之字形打印二叉树
 *
 * @author mudkip
 * @date 2022/7/29
 */
public class PrintTreesInZigzag {
    public <E> void print(BinaryTreeNode<E> root) {
        if (Objects.isNull(root)) {
            return;
        }

        ArrayList<Stack<BinaryTreeNode<E>>> list = new ArrayList<>();
        list.add(new Stack<>());
        list.add(new Stack<>());

        int current = 0;
        int next = 1;
        list.get(current).push(root);
        while (!list.get(0).isEmpty() || !list.get(1).isEmpty()) {
            BinaryTreeNode<E> node = list.get(current).pop();
            System.out.print(node.getValue() + " ");

            if (current == 0) {
                if (Objects.nonNull(node.getLeftChild())) {
                    list.get(next).push(node.getLeftChild());
                }
                if (Objects.nonNull(node.getRightChild())) {
                    list.get(next).push(node.getRightChild());
                }
            } else {
                if (Objects.nonNull(node.getRightChild())) {
                    list.get(next).push(node.getRightChild());
                }
                if (Objects.nonNull(node.getLeftChild())) {
                    list.get(next).push(node.getLeftChild());
                }
            }

            if (list.get(current).isEmpty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}

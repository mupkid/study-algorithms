package org.ohx.algorithmscommon.tree;

import java.util.*;

/**
 * 树工具类
 *
 * @author mudkip
 * @date 2022/4/13 23:43
 */
public final class TreeUtils {
    /**
     * 前序遍历（VLR)/先根遍历/先序遍历 打印树
     * <p>
     * 递归实现
     *
     * @param root 树根
     */
    public static <E> void VLRRecursion(BinaryTreeNode<E> root) {
        if (Objects.isNull(root)) {
            return;
        }

        System.out.println(root);
        VLRRecursion(root.getLeftChild());
        VLRRecursion(root.getRightChild());
    }

    /**
     * 前序遍历（VLR)/先根遍历/先序遍历 打印树
     * <p>
     * 非递归实现
     *
     * @param root 树根
     */
    public static <E> void VLRWithoutRecursion(BinaryTreeNode<E> root) {
        if (Objects.isNull(root)) {
            return;
        }
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root);
            // 右节点入栈
            if (Objects.nonNull(root.getRightChild())) {
                stack.push(root.getRightChild());
            }
            // 左节点入栈
            if (Objects.nonNull(root.getLeftChild())) {
                stack.push(root.getLeftChild());
            }
        }
    }

    /**
     * 宽度优先遍历/广度优先遍历/层序遍历 打印树
     *
     * @param root 树根
     */
    public static <E> void printBinaryTree(BinaryTreeNode<E> root) {
        if (root == null) {
            return;
        }

        List<E> list = new ArrayList<>();
        list.add(root.getValue());
        Queue<BinaryTreeNode<E>> queue = new ArrayDeque<>();
        if (!Objects.isNull(root.getLeftChild())) {
            queue.offer(root.getLeftChild());
        }
        if (!Objects.isNull(root.getRightChild())) {
            queue.offer(root.getRightChild());
        }
        while (!queue.isEmpty()) {
            BinaryTreeNode<E> poll = queue.poll();
            list.add(poll.getValue());
            if (!Objects.isNull(poll.getLeftChild())) {
                queue.offer(poll.getLeftChild());
            }
            if (!Objects.isNull(poll.getRightChild())) {
                queue.offer(poll.getRightChild());
            }
        }

        System.out.println(list);
    }

    private TreeUtils() {
    }
}

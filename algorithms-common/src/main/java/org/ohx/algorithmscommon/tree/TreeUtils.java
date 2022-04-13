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
     * 宽度优先遍历打印树
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

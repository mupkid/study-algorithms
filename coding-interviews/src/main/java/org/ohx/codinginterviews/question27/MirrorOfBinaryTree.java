package org.ohx.codinginterviews.question27;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/6/28
 */
public class MirrorOfBinaryTree {
    /**
     * 递归实现
     *
     * @param node
     * @param <E>
     */
    public <E> void mirrorRecursively(BinaryTreeNode<E> node) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.isNull(node.getLeftChild()) && Objects.isNull(node.getRightChild())) {
            return;
        }

        BinaryTreeNode<E> temp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(temp);

        if (Objects.nonNull(node.getLeftChild())) {
            mirrorRecursively(node.getLeftChild());
        }
        if (Objects.nonNull(node.getRightChild())) {
            mirrorRecursively(node.getRightChild());
        }
    }
}

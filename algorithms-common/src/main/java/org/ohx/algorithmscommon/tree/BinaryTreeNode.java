package org.ohx.algorithmscommon.tree;

/**
 * 二叉树节点
 *
 * @author mudkip
 * @date 2022/4/10 16:45
 */
public class BinaryTreeNode<E> {
    /**
     * 左叶子节点
     */
    private BinaryTreeNode<E> leftChild;

    /**
     * 右叶子节点
     */
    private BinaryTreeNode<E> rightChild;

    /**
     * 节点值
     */
    private E value;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode(E value, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

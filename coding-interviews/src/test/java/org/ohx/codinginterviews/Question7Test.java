package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.tree.TreeUtils;
import org.ohx.codinginterviews.question7.RebuildBinaryTree;

/**
 * @author mudkip
 * @date 2022/4/14 0:43
 */
public class Question7Test {
    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    @Test
    public void test1() {
        Integer[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    @Test
    public void test2() {
        Integer[] pre = {1, 2, 3, 4, 5};
        Integer[] vin = {5, 4, 3, 2, 1};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    @Test
    public void test3() {
        Integer[] pre = {1, 2, 3, 4, 5};
        Integer[] vin = {1, 2, 3, 4, 5};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }

    // 树中只有一个结点
    @Test
    public void test4() {
        Integer[] pre = {1};
        Integer[] vin = {1};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    @Test
    public void test5() {
        Integer[] pre = {1, 2, 4, 5, 3, 6, 7};
        Integer[] vin = {4, 2, 5, 1, 6, 3, 7};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }

    // 输入空指针
    @Test
    public void test6() {
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(null, null));
    }

    // 输入的两个序列不匹配
    @Test
    public void test7() {
        Integer[] pre = {1, 2, 4, 5, 3, 6, 7};
        Integer[] vin = {4, 2, 8, 1, 6, 3, 7};
        TreeUtils.printBinaryTree(RebuildBinaryTree.reConstructBinaryTree(pre, vin));
    }
}

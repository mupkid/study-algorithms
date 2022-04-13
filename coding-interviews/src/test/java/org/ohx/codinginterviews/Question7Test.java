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
}

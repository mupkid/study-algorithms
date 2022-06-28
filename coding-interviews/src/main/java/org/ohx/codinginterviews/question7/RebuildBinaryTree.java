package org.ohx.codinginterviews.question7;

import org.ohx.algorithmscommon.tree.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题7：重建二叉树
 * <p>
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author mudkip
 * @date 2022/4/13 20:55
 */
public class RebuildBinaryTree {
    /**
     * @param pre 前序遍历数组
     * @param vin 中序遍历数组
     * @param <E>
     * @return
     */
    public static <E> BinaryTreeNode<E> reConstructBinaryTree(E[] pre, E[] vin) {
        if (pre == null || vin == null || pre.length == 0 || vin.length == 0) {
            return null;
        }
        // 使用HashMap记录中序遍历数组的元素的位置
        HashMap<E, Integer> map = new HashMap<>();
        for (int i = 0; i < vin.length; i++) {
            map.put(vin[i], i);
        }
        return construct(pre, 0, pre.length - 1, vin, 0, vin.length - 1, map);
    }

    /**
     * @param pre      前序遍历数组
     * @param preStart 前序遍历数组开始的位置
     * @param preEnd   前序遍历数组结束的位置
     * @param vin      中序遍历数组
     * @param vinStart 中序遍历数组开始的位置
     * @param vinEnd   中序遍历数组结束的位置
     * @param map      中序遍历数组的元素的位置
     * @param <E>
     * @return
     */
    private static <E> BinaryTreeNode<E> construct(E[] pre, int preStart, int preEnd, E[] vin, int vinStart, int vinEnd,
                                                   Map<E, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历第一个数字，就是当前的根节点
        E rootValue = pre[preStart];
        int i = map.get(rootValue);
        return new BinaryTreeNode<>(rootValue, construct(pre, preStart + 1, preStart + i - vinStart, vin, vinStart, i - 1, map),
                construct(pre, preStart + 1 + i - vinStart, preEnd, vin, i + 1, vinEnd, map));
    }
}

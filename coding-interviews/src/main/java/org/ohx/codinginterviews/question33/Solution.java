package org.ohx.codinginterviews.question33;

import java.util.Objects;
import java.util.Stack;

/**
 * 牛客网版本：JZ33 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 数据范围： 节点数量 0 ≤ n ≤ 1000 ，节点上的值满足 1 ≤ val ≤ 10^5，保证节点上的值各不相同
 * <p>
 * 要求：空间复杂度 O(n)，时间时间复杂度 O(n^2)
 * <p>
 * 提示：
 * 1.二叉搜索树是指父亲节点大于左子树中的全部节点，但是小于右子树中的全部节点的树。
 * 2.该题我们约定空树不是二叉搜索树
 * 3.后序遍历是指按照 “左子树-右子树-根节点” 的顺序遍历
 *
 * @author mudkip
 * @date 2022/8/5
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        // 处理序列为空情况
        if (Objects.isNull(sequence) || sequence.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 以根，右子树，左子树顺序遍历
        for (int i = sequence.length - 1; i >= 0; i--) {
            // 确定根后一定是在右子树节点都遍历完了，因此当前sequence未遍历的节点中只含左子树，左子树的节点如果>root则说明违背二叉搜索的性质
            if (sequence[i] > root) {
                return false;
            }
            // 进入左子树的契机就是sequence[i]的值小于前一项的时候，这时可以确定root
            while (!s.isEmpty() && s.peek() > sequence[i]) {
                root = s.pop();
            }
            // 每个数字都要进一次栈
            s.add(sequence[i]);
        }
        return true;
    }
}

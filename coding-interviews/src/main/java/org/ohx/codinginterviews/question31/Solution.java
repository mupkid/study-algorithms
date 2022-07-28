package org.ohx.codinginterviews.question31;

/**
 * @author mudkip
 * @date 2022/7/28
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        // 表示栈空间的大小，初始化为0
        int n = 0;
        // 出栈序列的下标
        int j = 0;
        // 对于每个待入栈的元素
        for (int num : pushA) {
            // 加入栈顶
            pushA[n] = num;
            // 当栈不为空且栈顶等于当前出栈序列
            while (n >= 0 && pushA[n] == popA[j]) {
                // 出栈，缩小栈空间
                j++;
                n--;
            }
            n++;
        }
        // 最后的栈是否为空
        return n == 0;
    }
}

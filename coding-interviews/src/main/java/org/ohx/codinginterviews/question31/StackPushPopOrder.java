package org.ohx.codinginterviews.question31;

import java.util.Objects;
import java.util.Stack;

/**
 * @author mudkip
 * @date 2022/7/28
 */
public class StackPushPopOrder {
    public boolean isPopOrder(int[] pPush, int[] pPop) {
        if (Objects.isNull(pPush) || Objects.isNull(pPop) || pPush.length != pPop.length) {
            return false;
        }

        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pPush.length) {
            stack.push(pPush[i]);
            i++;
            while (!stack.isEmpty() && pPop[j] == stack.peek()) {
                stack.pop();
                j++;
                if (j >= pPop.length) {
                    return true;
                }
            }
        }

        while (j < pPop.length) {
            if (pPop[j] == stack.peek()) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }

        return true;
    }
}

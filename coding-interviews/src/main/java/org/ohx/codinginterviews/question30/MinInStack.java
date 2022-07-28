package org.ohx.codinginterviews.question30;

import java.util.Stack;

/**
 * @author mudkip
 * @date 2022/7/28
 */
public class MinInStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    public void push(int item) {
        stack.push(item);
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            minStack.push(Math.min(minStack.peek(), item));
        }
    }

    public Integer min() {
        return minStack.peek();
    }

    public Integer top() {
        return stack.peek();
    }
}

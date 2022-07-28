package org.ohx.codinginterviews.question30;

import java.util.Stack;

/**
 * @author mudkip
 * @date 2022/7/28
 */
public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int peek = minStack.peek();
            minStack.push(Math.min(peek, node));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

package org.ohx.leetcode.problem155;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private final Deque<int[]> stack = new ArrayDeque<>();

    public MinStack() {
        // 添加栈底哨兵 Integer.MAX_VALUE
        // 这里的 0 写成任意数都可以，反正用不到
        stack.push(new int[]{0, Integer.MAX_VALUE});
    }

    public void push(int val) {
        stack.push(new int[]{val, Math.min(getMin(), val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

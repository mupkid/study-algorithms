package org.ohx.codinginterviews.question9;

import java.util.Stack;

/**
 * 面试题9：用两个栈实现队列
 * <p>
 * 实现两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * </p>
 *
 * @author mudkip
 * @date 2022/4/10 15:44
 */
public class CQueue<T> {
    private final Stack<T> stack1;
    private final Stack<T> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 入队，appendTail方法
     *
     * @param node 节点
     */
    public void offer(T node) {
        stack1.push(node);
    }

    /**
     * 出队，deleteHead方法
     *
     * @return 队头
     */
    public T poll() {
        // 如果栈2是空的，先把栈1的内容全部压到栈2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // 如果栈2还是空的，说明没有任何内容，返回空
        if (stack2.isEmpty()) {
            return null;
        }

        // 直接返回栈顶
        return stack2.pop();
    }
}

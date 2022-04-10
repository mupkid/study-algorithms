package org.ohx.codinginterviews.question9;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 扩展题：使用两个队列实现栈
 *
 * @author mudkip
 * @date 2022/4/10 16:16
 */
public class CStack<T> {
    private final Queue<T> queue1;
    private final Queue<T> queue2;

    public CStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public void push(T node) {
        if (!queue2.isEmpty()) {
            queue2.offer(node);
        } else {
            queue1.offer(node);
        }
    }

    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }

        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }

        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }

        return null;
    }
}

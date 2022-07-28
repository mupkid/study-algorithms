# 面试题30：包含 min 函数的栈
> 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数。在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

标签：`栈`

## 1 双栈法
使用一个栈存进栈的元素，另外一个栈存栈中最小的元素。

两个栈同步入栈出栈，就能够保证最小的元素出栈后，调用 min 方法出来的是第二小的元素。
```java
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
```
# [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)

## 思路

栈

## 单调栈（从右到左）

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            // 栈内存的是数组的下标而不是元素本身，因为可以直接通过下标访问数组
            stack.push(i);
        }
        return ans;
    }
}
```

## 单调栈（从左到右）
从右到左相当于，已找到一个大的元素。
从左到右相当于，栈内的元素是还没有找到下一个更大的。

从左到右更符合单调栈的思想。

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // todolist
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!st.isEmpty() && t > temperatures[st.peek()]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        return ans;
    }
}
```
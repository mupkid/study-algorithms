package org.ohx.leetcode.problem84;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 预处理数组：前后补0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[newHeights.length - 1] = 0;

        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;

        for (int i = 0; i < newHeights.length; i++) {
            int h = newHeights[i];
            // 当当前高度小于栈顶高度时，触发面积计算
            while (!stack.isEmpty() && h < newHeights[stack.peek()]) {
                int dh = newHeights[stack.pop()];
                int dw = i - stack.peek() - 1; // 左边界为新栈顶索引，右边界为i
                ans = Math.max(ans, dh * dw);
            }
            stack.push(i);
        }
        return ans;
    }
}
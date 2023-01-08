package org.ohx.leetcode.question358;

import java.util.*;

/**
 * @author mudkip
 * @date 2022/11/14
 */
class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Character c : s.toCharArray()) {
            // 遍历字符，统计字符的出现次数
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 装入大顶堆，按照字符重复次数作为比较
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder(s.length());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            // 从大顶堆取出重复次数最多的字符
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            sb.append(currentEntry.getKey());
            // 用掉一个字符，次数减一
            currentEntry.setValue(currentEntry.getValue() - 1);
            // 放入到queue中，因为k距离后还要用。
            queue.offer(currentEntry);
            if (queue.size() == k) {
                // queue的大小到达了k，也就是说我们已经越过了k个单位，在结果中应该要出现相同的字母了
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    // 该字符的重复次数大于 0，则添加入大顶堆中，要是0那还加它干嘛
                    maxHeap.add(entry);
                }
            }
        }
        // 退出 while 循环就是大顶堆已经没有元素了，如果此时 sb 的长度没有还原，说明还有元素挂在 queue 中
        // 即 queue.size() == k 这个条件没有完全满足，即存在一些字符无法间隔 k 个距离
        return sb.length() == s.length() ? sb.toString() : "";
    }
}

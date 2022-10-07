package org.ohx.leetcode.question347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author mudkip
 * @date 2022/10/7
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            if (pq.isEmpty()) {
                break;
            }
            ret[i] = pq.remove();
        }
        return ret;
    }
}

# [56. 合并区间](https://leetcode.cn/problems/merge-intervals/)

以数组`intervals`表示若干个区间的集合，其中单个区间为`intervals[i] = [starti, endi]`。
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

## 思路

首先会想到给数组按照左端点排序后，然后判断右端点是否和下一个左端点重合。

## 排序


## BitSet
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            int temp = interval[1] * 2 + 1;
            bitSet.set(interval[0] * 2, temp, true);
            max = Math.max(temp, max);
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        System.arraycopy(intervals, 0, ret, 0, count);

        return ret;
    }
}

```
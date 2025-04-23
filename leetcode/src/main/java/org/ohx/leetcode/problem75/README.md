# [75. 颜色分类](https://leetcode.cn/problems/sort-colors/)

## 

荷兰国旗问题

参考快排的思想。

使用两个变量把数组分成三段
* 变量 l 为下一个填入 0 的位置，即 `[0, l - 1]` 均为 0，初始化 l = 0，代表空集。
* 变量 r 为下一个填入 2 的位置，即 `[r + 1, n - 1]` 均为 2，初始化 r = n - 1，代表空集。

遍历变量 i 表示当前处理到的位置，那么 `[0, i - 1]` 就是已经处理过的元素，`[l, i - 1]` 就是 1 的区间，`[i, r]` 为待处理的元素。

* 当 `nums[i] = 0` 时，把 i 和 l 的元素进行互换，本质是把 0 和 1 进行互换，然后 i++、l++
* 

## 双指针法

```java

```

## 刷漆法

```java
class Solution {
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[n1++] = 1;
            }
            if (num < 1) {
                nums[n0++] = 0;
            }
        }
    }
}
```
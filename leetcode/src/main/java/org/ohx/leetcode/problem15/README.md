# [三数之和](https://leetcode.cn/problems/3sum/description)

## 排序 + 双指针

排序的目的是确保不会取到重复的数字，即当求出 (a, b, c) 时，不需要再去考虑 (b, a, c) 的情况。

只要定下 a，问题就会变成求两数之和。排序完后，从左到右遍历数组定下 a，那么在 a 的右侧就通过双指针找出 b 和 c 的所有组合。
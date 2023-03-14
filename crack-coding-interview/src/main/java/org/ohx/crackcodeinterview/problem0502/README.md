# [面试题05.02 二进制数转字符串](https://leetcode.cn/problems/bianry-number-to-string-lcci/)

> 二进制数转字符串，给定一个介于 0 和 1 之间的实数（如 0.72），类型为 double，打印它的二进制表达式。如果该数字无法精确地用 32 位以内的二进制表示，则打印“ERROR"。

示例1：

```text
输入： 0.625
输出： "0.101"
```

示例2：

```text
输入： 0.1
输出： "ERROR"
```

## 1

将实数的十进制表示转换成二进制表示的方法是：每次将实数乘以 2，将此时的整数部分添加到二进制表示的末尾，然后将整数部分置为 0。重复上述操作，直到小数部分变成 0 或者小数部分出现循环时结束操作。
# 面试题15：二进制中1的个数

题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如：把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。

数据范围：-2^{31} <= n <= 2^{31}-1

即范围为：-2147483648 <= n <= 2147483647

示例1
```text
输入：10
返回值：2
说明：十进制中10的32位二进制表示为0000 0000 0000 0000 0000 0000 0000 1010，其中有两个1。
```

示例2
```text
输入：-1
返回值：32
说明：负数使用补码表示 ，-1的32位二进制表示为1111 1111 1111 1111 1111 1111 1111 1111，其中32个1
```

相关标签：`基础数学` `位运算`

## 1 常规解法

首先n与1做与运算，判断最低位是不是1。接着把1左移一位得到2，判断n的次低位是不是1。循环32次后，得到结果。

```java
public int numberOfOne(int n) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
        if (n & flag) {
            count++;
        }
        flag = flag << 1;
    }
    return count;
}
```
## 2 
把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0。那么一个整数有多少个1，就可以进行多少次这样的操作。
```java
public int numberOfOne(int n) {
    int count = 0;
    while (n != 0) {
        ++count;
        n = (n - 1) & n;
    }
    return count;
}
```



**记住**：把整数右移一位和把整数除以2在数学上是等价的，但除法的效率比移位运算要低得多，在实际编程中应尽可能地用以为运算符代替乘除法。
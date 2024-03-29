# 779. 第K个语法符号

## 方法1

观察每一行

```text
0
01
0110
01101001
0110100110010110
```

每一行的后半部分正好为前半部分的“翻转”——前半部分是 00 后半部分变为 11，前半部分是 11，后半部分变为 00。且每一行的前半部分和上一行相同。

再次思考原问题：对于查询某一个行第 k 个数字，如果 k
在后半部分，那么原问题就可以转化为求解该行前半部分的对应位置的“翻转”数字，又因为该行前半部分与上一行相同，所以又转化为上一行对应对应的“翻转”数字。那么按照这样一直递归下去，并在第一行时返回数字 0 即可。

```java
class Solution {
    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }
}
```

## 方法2

本质上我们其实只需要求在过程中的“翻转”总次数，如果“翻转”为偶数次则原问题求解为 0，否则为 1。

最后“翻转”的总次数只和初始状态下的下标 x 二进制表示中 1 的个数有关。因此原问题中求“翻转”的总次数就等价于求 k−1 的二进制表示中 1 的个数，

```java
class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
```

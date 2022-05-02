# 面试题16：数值的整数次方

题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

相关标签：`基础数学` `递归`

## 1 常规运算

## 2 递归
```java
/**
 * 递归求幂
 *
 * @param base     底数
 * @param exponent 指数
 * @return 幂
 */
public double power(double base, int exponent) {
    return exponent > 0 ? recursionPow(base, exponent) : recursionPow(1 / base, -exponent);
}

private double pow(double base, int exponent) {
    if (exponent == 0) {
        return 1;
    }
    if (exponent == 1) {
        return base;
    }
    return recursionPow(base, exponent / 2) * recursionPow(base, exponent - exponent / 2);
}
```
## 3 快速幂
```java
public static double quickPower(double base, int exponent) {
    // 处理负数次方
    if (exponent < 0) {
        base = 1 / base;
        exponent = -exponent;
    }
    double res = 1;
    while (exponent != 0) {
        // 可以再往上乘一个
        if ((exponent & 1) == 1) {
            res *= base;
        }
        // 叠加
        base *= base;
        // 减少乘次数
        exponent >>= 1;
    }
    return res;
}
```
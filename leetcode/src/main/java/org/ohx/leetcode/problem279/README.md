# [279. 完全平方数](https://leetcode.cn/problems/perfect-squares/)

## 思路

设 i 为前 i 个数，c 为用前 i 个数的平方凑成的和，那么最小数量 `dp[i, c]` 有：
`dp[i, c] = dp[i -1 , c], c < i * i`,
`dp[i, c] = min(dp[i -1 , c], dp[i, c - i * i] + 1), c >= i * i`。

## 动态规划

### 递归

### 递推

把递推式转成二维数组 f，得到：
`f[i + 1][c] = min(f[i][c], f[i + 1][c - i * i] + 1)`

### 压缩到两行二维数组

### 压缩到一行二维数组

得到递推式：
`f[c] = min(f[c], f[c - i * i] + 1)`

```java
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        }
        return f[n];
    }
}
```
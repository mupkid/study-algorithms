# [322. 零钱兑换](https://leetcode.cn/problems/coin-change)

## DP

假设用 i 表示数组的前 i 种硬币，用 c 表示用这 i 种硬币组成金额 c，`dp[i][c]`表示用前 i 种硬币组成金额 c 的最少硬币数，那么有该转移方程：

`dp[i][c] = min(dp[i - 1][c], dp[i][c - coins[i]] + 1)`

类比完全背包问题
* i 就是前 i 种物品，等同前 i 种硬币
* c 就是背包容量，等同组成金额 c
* 1 就是对应物品的价值

### 递归

```java

```

### 递推

把递推式转成
`f[i + 1][c] = min(f[i][c], f[i + 1][c - coins[i]] + 1)`

### 压缩二维数组

### 压缩一维数组

`f[c] = min(f[c], f[c - coins[i]] + 1)`

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                f[j] = Math.min(f[j], f[j - coin] + 1);
            }
        }
        return f[amount] == amount + 1 ? -1 : f[amount];
    }
}
```
# []()

## DP

### 递归

### 递推

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }

        target /= 2;
        int length = nums.length;
        // 初始化二维数组
        int[][] dp = new int[nums.length + 1][target + 1];
        // 边界条件
        dp[0][0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    // 目标的值小于当前数字，只能不选
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
            }
        }
        return dp[length][target];
    }
}
```

### 压缩二维数组

根据状态转移方程，每次计算只需要上一行的值，那么可以只需要两行二维数组就可以。

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }

        target /= 2;
        int length = nums.length;
        // 初始化二维数组
        int[][] dp = new int[2][target + 1];
        // 边界条件
        dp[0][0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    // 目标的值小于当前数字，只能不选
                    dp[(i + 1) % 2][j] = dp[i % 2][j];
                } else {
                    dp[(i + 1) % 2][j] = dp[i % 2][j] + dp[i % 2][j - nums[i]];
                }
            }
        }
        return dp[length % 2][target];
    }
}
```

### 压缩一维数组

如果只用一个一维数组来存储，递推方程会变成：
`f[j] = f[j] + f[j - nums[i]]`

如果从左到右开始算，那么 `f[j - nums[i]]` 的值会被先修改导致算错。而从右到左开始算就没有这个问题。

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }

        target /= 2;
        int[] dp = new int[target + 1];
        // 边界条件
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }
}
```
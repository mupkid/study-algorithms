package org.ohx.nowcoder.huawei;

import java.util.Scanner;

/**
 * 01背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public static String zeroOnePack(int v, int n, int[] weight, int[] value) {
        // 动态规划数组
        int[][] dp = new int[n + 1][v + 1];
        // 为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                // 如果第i件物品的重量大于背包容量j,则不装入背包
                // 由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[n][v];

        //逆推找出装入背包的所有商品的编号
        int j = v;
        StringBuilder numStr = new StringBuilder();
        for (int i = n; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr.insert(0, i + " ");
                j = j - weight[i - 1];
            }
            if (j == 0) {
                break;
            }
        }
        return numStr.toString();
    }

    /**
     * 01背包优化解法
     *
     * @param v      背包容量
     * @param n      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public static int zeroOnePack2(int v, int n, int[] weight, int[] value) {
        // 动态规划数组
        int[] dp = new int[v + 1];
        for (int i = 1; i < n + 1; i++) {
            // 逆序实现
            for (int j = v; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[v];
    }
}

package org.ohx.codinginterviews.problem63;

/**
 * @author mudkip
 * @date 2023/3/12
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}

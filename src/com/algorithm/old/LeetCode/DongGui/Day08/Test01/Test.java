package com.algorithm.old.LeetCode.DongGui.Day08.Test01;


public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 6, 1, 2, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(nums));

    }

}


class Solution {
    public int maxProfit(int[] prices) {

        int cash = 0;//现金
        int hold = -prices[0];//股票

        int len = prices.length;

        int[][] dp = new int[len][3];

        dp[0][0] = -prices[0];
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // dp[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益

        for (int i = 1; i < prices.length; i++) {

            //比较 i-1天的时候 之前的收益 和 利用之前手上的收益买入股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);

            //i-1天的时候 之前的收益 + 当天卖出股票赚的钱
            dp[i][1] = dp[i - 1][0] + prices[i];

            //第i天不持有股票，那么第i-1天可能处于冷冻期，也可能不处于冷冻期
            //比较 i-1天的时候 之前是冷冻期时的最大收益 和 不是冷冻期时的最大收益
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);

        }

        //最后一天时，如果仍然持有股票则此股票没有意义。因此比较一下不持有股票时，冷冻期和非冷冻期的最大收益
        return Math.max(dp[len - 1][1], dp[len - 1][2]);

    }
}

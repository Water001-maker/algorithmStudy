package com.algorithm.old.LeetCode.DongGui.Day07.Test03;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(nums));
        System.out.println(solution.maxProfit2(nums));
        System.out.println(solution.maxProfit3(nums));
    }
}


class Solution {
    //贪心
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }

    //动规
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;

        // 0：持有现金
        // 1：持有股票
        //翻转两次回到原本的状态
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//前一天已经没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，这时候我们要将其卖出，并获得 \textit{prices}[i]prices[i] 的收益。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//前一天已经持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，或者前一天结束时还没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，这时候我们要将其买入，并减少 \textit{prices}[i]prices[i] 的收益。
        }
        return dp[prices.length - 1][0];
    }

    //动规 优化
    public int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;

        // cash：持有现金
        // hold：持有股票
        //翻转两次回到原本的状态
        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
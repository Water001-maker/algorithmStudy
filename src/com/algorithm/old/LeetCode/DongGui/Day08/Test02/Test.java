package com.algorithm.old.LeetCode.DongGui.Day08.Test02;

public class Test {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 2, 8, 4, 9};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(nums,2));

    }

}

class Solution {
    public int maxProfit(int[] prices, int fee) {

        int len = prices.length;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len-1][0];
    }
}

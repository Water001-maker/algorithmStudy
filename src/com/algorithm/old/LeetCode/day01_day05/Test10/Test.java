package com.algorithm.old.LeetCode.day01_day05.Test10;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.climbStairs(3);
        System.out.println(i);

        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i1 = solution.minCostClimbingStairs(cost);

        System.out.println(i1);

    }

}

class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            if (i != cost.length) {
                dp[i] = cost[i];
            }
            dp[i] += Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[cost.length];
    }

}
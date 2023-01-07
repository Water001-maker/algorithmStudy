package com.algorithm.LeetCode.DongGui.Day11.Test01;

public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));

    }

}

class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //j-1 为j为头结点左子树节点数量
                //i-j 为j为头结点柚子树结点数量
                dp[i] += dp[j - 1] * dp[i - j];
                //以3为例 dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
            }
        }

        return dp[n];

    }
}
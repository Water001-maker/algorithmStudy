package com.algorithm.LeetCode.DongGui.Day11.Test02;

public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));

    }

}

class Solution {
    public int nthUglyNumber(int n) {

        int n2 = 0;
        int n3 = 0;
        int n5 = 0;

        int[] dp = new int[n];
        dp[0] = 1;

        if (n == 1) return 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2 * dp[n2], Math.min(3 * dp[n3], 5 * dp[n5]));
            if (dp[i] == 2 * dp[n2]) n2++;
            if (dp[i] == 3 * dp[n3]) n3++;
            if (dp[i] == 5 * dp[n5]) n5++;
        }
        return dp[n - 1];
    }
}
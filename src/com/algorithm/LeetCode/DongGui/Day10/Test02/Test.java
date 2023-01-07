package com.algorithm.LeetCode.DongGui.Day10.Test02;

public class Test {

    public static void main(String[] args) {

        String s = "1227222";

        Solution solution = new Solution();

        int i = solution.numDecodings(s);

        System.out.println(i);

    }

}

class Solution {
    public int numDecodings(String s) {

        int len = s.length();

        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            //一位数
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            //两位数
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {//1-26
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
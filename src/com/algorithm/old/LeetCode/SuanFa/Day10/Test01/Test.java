package com.algorithm.old.LeetCode.SuanFa.Day10.Test01;

public class Test {

    public static void main(String[] args) {

        int i = 18580;
        Solution solution = new Solution();
        System.out.println(solution.translateNum(i));
    }

}


class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String nums = str.substring(i - 2, i);//str.substring  截取掉str从首字母起长度为startIndex的字符串，将剩余字符串赋值给str；
            if (Integer.parseInt(nums) >= 10 && Integer.parseInt(nums) <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length-1];
    }
}
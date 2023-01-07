package com.algorithm.LeetCode.DongGui.Day03.Test01;

public class Test {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 1};

        Solution solution = new Solution();
        int rob = solution.rob(ints);
        System.out.println(rob);


        int rob2 = solution.rob2(ints);
        System.out.println(rob2);
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = second;//记录当前最大值
            second = Math.max(first + nums[i], second);//比较，将较大值输出
            first = temp;//将最小值覆盖
        }
        return second;
    }

    public int rob2(int[] nums) {

        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);//比较，将较大值输出
        }
        return dp[n-1];
    }
}
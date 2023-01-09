package com.algorithm.old.LeetCode.DongGui.Day03.Test02;

public class Test {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 1};

        Solution solution = new Solution();
        int rob = solution.rob(ints);
        System.out.println(rob);

    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n + 1];
        int i;

        //0——n-1
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (i = 2; i <= n - 2; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int x = Math.max(dp[i - 1], dp[i]);

        //1——n
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (i = 3; i <= n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int y = Math.max(dp[i - 1], dp[i]);
        return Math.max(x, y);
    }
}

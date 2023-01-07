package com.algorithm.LeetCode.DongGui.Day05.Test02;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, 3, 5};

        Solution solution = new Solution();
        int i = solution.maxSubarraySumCircular(nums);
        System.out.println(i);
    }
}

/**
 * 通过最大子数组 和 数组总和-最小子数组 比较
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMax = 0;
        int curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
package com.algorithm.old.LeetCode.SuanFa.Day09.Test01;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int i = solution.maxSubArray(nums);
        System.out.println(i);
    }

}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
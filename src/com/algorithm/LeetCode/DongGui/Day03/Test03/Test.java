package com.algorithm.LeetCode.DongGui.Day03.Test03;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 4, 6, 2};

        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(nums));
    }

}

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return robRange(sum);
    }

    public int robRange(int[] nums) {
        int len = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}